package jp.itacademy.gae_sample.controller.task;

import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.logging.Logger;

import jp.itacademy.gae_sample.meta.SaleItemMeta;
import jp.itacademy.gae_sample.model.Item;
import jp.itacademy.gae_sample.model.SaleItem;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

public class ItemUpdateController extends Controller {
    
    private static final Logger logger = Logger.getLogger(ItemUpdateController.class.getName());

    @Override
    public Navigation run() throws Exception {
        
        Validators v = new Validators(request);
        v.add("id", v.required(), v.longType());
        v.add("timestamp", v.required(), v.longType());
        if (!v.validate()){
            logger.warning("パラメータが正しくありません" + errors);
            return null;
        }
        
        long id = asLong("id");
        long timestamp = asLong("timestamp");
        
        Key key = Datastore.createKey(Item.class, id);
        Item item = Datastore.getOrNull(Item.class, key);
        if (item == null){
            logger.warning("パラメータidに該当するアイテムがありません：　" + id);
            return null;
        }
        
        SaleItemMeta m = SaleItemMeta.get();
        
        while (true){
            List<Key> saleItemKeys = 
                    Datastore
                        .query(m)
                        .filter(
                            m.itemKey.equal(key),
                            m.lastUpdateTimestamp.lessThan(timestamp))
                        .asKeyList();
            
            if (saleItemKeys.isEmpty()){
                break;
            }
            
            for (Key saletemKey : saleItemKeys){
                Transaction tx = Datastore.beginTransaction();
                
                try{
                    SaleItem saleItem =
                            Datastore.get(tx, SaleItem.class, saletemKey);
                    
                    if (saleItem.getLastUpdateTimestamp() >= timestamp){
                        continue;
                    }
                    
                    saleItem.setItemName(item.getName());
                    saleItem.setItemPrice(item.getPrice());
                    saleItem.setLastUpdateTimestamp(timestamp);
                    Datastore.put(tx, saleItem);
                    
                    tx.commit();
                }catch (ConcurrentModificationException e) {
                    continue;
                }finally{
                    if (tx.isActive()){
                        tx.rollback();
                    }
                }
            }
        }

        return null;
    }
}

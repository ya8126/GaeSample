package jp.itacademy.gae_sample.controller.taskqueue;

import java.util.ArrayList;
import java.util.List;

import jp.itacademy.gae_sample.model.Item;
import jp.itacademy.gae_sample.model.SaleItem;
import jp.itacademy.gae_sample.model.Shop;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class PrepareController extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        Item item1 = new Item(1, "�₭����", 8);
        Item item2 = new Item(2, "�ǂ���������", 10);
        Item item3 = new Item(3, "��������", 20);
        Item item4 = new Item(4, "�܂񂰂���", 30);
        
        Shop shop1 = new Shop(1, "����[�Ǒ��̓��");
        Shop shop2 = new Shop(2, "�������Ƒ��̓��");
        
        List<Object> models = new ArrayList<Object>();
        models.add(item1);
        models.add(item2);
        models.add(item3);
        models.add(item4);
        models.add(shop1);
        models.add(shop2);
        models.add(new SaleItem(shop1, item1));
        models.add(new SaleItem(shop1, item2));
        models.add(new SaleItem(shop1, item3));
        models.add(new SaleItem(shop2, item1));
        models.add(new SaleItem(shop2, item2));
        models.add(new SaleItem(shop2, item4));
        Datastore.put(models);
             
        return forward("prepare.jsp");
    }
}

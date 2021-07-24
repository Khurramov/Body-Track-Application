package com.example.bodytrack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class gain extends AppCompatActivity {

    private String[] names = {"Meat","Milk","Fish","Nuts","Potatoes","Protein","Rice","Supplements"};
    private int[] images = {R.drawable.meat,R.drawable.milk,R.drawable.fish,R.drawable.nuts,R.drawable.potatoes,
            R.drawable.protein,R.drawable.rice,R.drawable.supplements};
    private String[] description={"Red meats are probably one of the best muscle-building foods available.\n" +
            "\n" +
            "For example, 6 ounces (170 grams) of steak contains around 5 grams of leucine.\n" +
            "\n" +
            "Leucine is the key amino acid your body needs to stimulate muscle protein synthesis and add new muscle tissue. It also contains 456 calories and nearly 49 grams of protein.\n" +
            "\n" +
            "In addition to this, red meats are one of the best natural sources of dietary creatine, which is possibly the world’s best muscle-building supplement ",


            "Try drinking one or two glasses of whole milk (149 calories per cup) as a snack, " +
                    "with a meal, or before and after a workout if you’re training.\n" +
                    "\n" +
                    "Milk smoothies are also a delicious way to add milk to your diet. For an easy morning protein boost, " +
                    "try blending up 1 cup of frozen berries, 1 cup of whole milk, " +
                    "2 teaspoons of honey, and 1 teaspoon of vanilla (about 275 calories).",


            "Like red meat, salmon and oily fish are excellent sources of protein and important healthy fats.\n" +
                    "\n" +
                    "Out of all the nutrients that salmon and oily fish provide, omega-3 fatty acids are among the most significant and well known.\n" +
                    "\n" +
                    "They offer numerous benefits for your health and help fight diseases.Just one 6-ounce (170-gram) fillet of deboned wild sockeye salmon provides around 250 calories and 12 grams of healthy fats. The same serving packs 37 grams of high quality protein, helping you build muscle or gain weight " +
                    "You can prepare salmon in a variety of ways: steamed, sautéed, smoked, grilled, baked, or poached. You can also try smoked salmon or even eat raw salmon in sushi and sashimi.",


            "Nuts and nut butters are perfect choices if you’re looking to gain weight.\n" +
                    "\n" +
                    "Just one small handful of raw almonds (1/4 cup) contains 170 calories, 6 grams of protein, 4 grams of fiber, and 15 grams of healthy fats" +
                    "You can add nut butters to a variety of snacks or dishes, such as smoothies, yogurts, and crackers, to turn them into a high calorie snack in no time.\n" +
                    "\n" +
                    "For a quick pick-me-up, try peanut butter banana smoothie, with only three ingredients (270 calories, using whole milk). If you have a peanut allergy, substitute another nut butter.\n" +
                    "\n" +
                    "However, make sure you pick 100 percent nut butters with no added sugar or extra oils. Or better yet, make your own from this homemade almond butter recipe. It’s easy to make and easy on your wallet, too.",


            "Potatoes and other starchy foods are a very easy and cost-effective way to add in extra calories." +
                    "With sweet potatoes, you can try out one of the current Instagram trends: sweet potato toast. Prep takes only minutes. Start by washing, drying, and thinly slicing a medium-sized sweet potato, then toast it to your liking either in a toaster or a toaster oven.\n" +
                    "\n" +
                    "Then you add your favorite toppings. For example, slather it with mashed avocado and top with a fried egg (300 calories per serving). You’ve got yourself a perfect breakfast or post-workout snack.",


            "Taking protein supplements is a common strategy for athletes and bodybuilders who want to gain weight. There are many types available, including whey, soy, egg, and pea protein.\n" +
                    "\n" +
                    "Whey protein supplements and mass gainers (supplements that can help you gain muscle mass) can be very easy and cost-effective strategies to gain weight, especially when combined with strength training" +
                    "The easiest way to add protein powder into your diet is with a protein smoothie, especially for breakfast. That gives you the rest of the day to add in nutritious meals and snacks to make sure you get a balanced nutrient intake.\n" +
                    "\n" +
                    "Generally, a smoothie that you make yourself will be more nutritious than buying one that’s ready-made, which may have added sugar and flavorings.",


            "Rice is a convenient, low cost carb source to help you gain weight. Just 1 cup (158 grams) of cooked white rice provides 204 calories, 44 grams of carbs, and very little fat" +
                    "When you’re on the go or in a rush, 2-minute packs of microwavable rice can be easily added to other protein sources and premade meals.\n" +
                    "\n" +
                    "Another popular method is to prepare a large pot of rice, refrigerate it or freeze individual portions, and then combine it with different proteins and healthy fats for varied meals throughout the week." +
                    "A rice dish can easily become a whole meal. Try this wild rice and chicken kale for a healthy lunch (400 calories per serving).",


            "Never give up"};


    private List<ItemsModal> itemsModalList=new ArrayList<>();
    GridView gridView;
    CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gain);

       for(int i=0; i<names.length;i++){

           ItemsModal itemsModal=new ItemsModal(images[i],names[i],description[i]);
           itemsModalList.add(itemsModal);
       }

       gridView = findViewById(R.id.gridview);
       customAdapter=new CustomAdapter(itemsModalList,this);

       gridView.setAdapter(customAdapter);


    }

    public static class CustomAdapter extends BaseAdapter{

        private List<ItemsModal> itemsModalList;
        private Context context;

        public CustomAdapter(List<ItemsModal> itemsModalList, Context context) {
            this.itemsModalList = itemsModalList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return itemsModalList.size();
        }

        @Override
        public Object getItem(int i) {
            return itemsModalList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1=view;

            ItemsModal itemsModal=itemsModalList.get(i);

            if(view1==null){
                view1= LayoutInflater.from(context).inflate(R.layout.row_detail,viewGroup,false);
            }
            ImageView imageName=view1.findViewById(R.id.imageName);
            TextView tvName=view1.findViewById(R.id.tvName);
            TextView tcDesc=view1.findViewById(R.id.tvDesc);

            String name=itemsModal.getName();
            String desc=itemsModal.getDescription();
            int image=itemsModal.getImage();

            imageName.setImageResource(image);
            tvName.setText(name);
            tcDesc.setText(desc);
            return view1;
        }
    }
}
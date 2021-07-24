package com.example.bodytrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class lose extends AppCompatActivity {

    private String[] names = {"Low-Carb diets","The Dash diet","Intermittent fasting","Low-fat fasting","The Mediterranean diet","Plant-based diets","The Paleo diet","WW(Weight Watchers)"};
    private int[] images = {R.drawable.crawb,R.drawable.dash,R.drawable.fasting,R.drawable.lowfat,R.drawable.midaterrian,
            R.drawable.plant,R.drawable.paleo,R.drawable.ww};
    private String[] description={"Low-carb diets are among the most popular diets for weight loss. Examples include the Atkins diet, ketogenic (keto) diet, and low-carb, high-fat (LCHF) diet.\n" +
            "\n" +
            "Some varieties reduce carbs more drastically than others. For instance, very-low-carb diets like the keto diet restrict this macronutrient to under 10% of total calories, compared with 30% or less for other types" +
            "How it works: Low-carb diets restrict your carb intake in favor of protein and fat.\n" +
            "\n" +
            "They’re typically higher in protein than low-fat diets, which is important, as protein can help curb your appetite, raise your metabolism, and conserve muscle mass.\n" +
            "\n" +
            "In very-low-carb diets like keto, your body begins using fatty acids rather than carbs for energy by converting them into ketones. This process is called ketosis ",


            "Dietary Approaches to Stop Hypertension, or DASH diet, is an eating plan that is designed to help treat or prevent high blood pressure, which is clinically known as hypertension." +
                    "How it works: The DASH diet recommends specific servings of different food groups. The number of servings you are allowed to eat depends on your daily calorie intake.\n" +
                    "\n" +
                    "For example, an average person on the DASH diet would eat about 5 servings of vegetables, 5 servings of fruit, 7 servings of healthy carbs like whole grains, 2 servings of low-fat dairy products, and 2 servings or fewer of lean meats per day.\n" +
                    "\n" +
                    "In addition, you’re allowed to eat nuts and seeds 2–3 times per week",


            "Intermittent fasting is a dietary strategy that cycles between periods of fasting and eating.\n" +
                    "\n" +
                    "Various forms exist, including the 16/8 method, which involves limiting your calorie intake to 8 hours per day, and the 5:2 method, which restricts your daily calorie intake to 500–600 calories twice per week.\n" +
                    "\n" +
                    "How it works: Intermittent fasting restricts the time you’re allowed to eat, which is a simple way to reduce your calorie intake. This can lead to weight loss — unless you compensate by eating too much food during allowed eating periods.\n" +
                    "\n" +
                    "Weight loss: In a review of studies, intermittent fasting was shown to cause 3–8% weight loss over 3–24 weeks, which is a significantly greater percentage than other methods",


            "Like low-carb diets, low-fat diets have been popular for decades.\n" +
                    "\n" +
                    "In general, a low-fat diet involves restricting your fat intake to 30% of your daily calories.\n" +
                    "\n" +
                    "Some very- and ultra-low-fat diets aim to limit fat consumption to under 10% of calories.\n" +
                    "\n" +
                    "How it works: Low-fat diets restrict fat intake because fat provides about twice the number of calories per gram, compared with the other two macronutrients — protein and carbs.\n" +
                    "\n" +
                    "Ultra-low-fat diets contain fewer than 10% of calories from fat, with approximately 80% of calories coming from carbs and 10% from protein.\n" +
                    "\n" +
                    "Ultra-low-fat diets are mainly plant-based and limit meat and animal products.",


            "The Mediterranean diet is based on foods that people in countries like Italy and Greece used to eat.\n" +
                    "\n" +
                    "Though it was designed to lower heart disease risk, numerous studies indicate that it can also aid weight loss (53Trusted Source).\n" +
                    "\n" +
                    "How it works: The Mediterranean diet advocates eating plenty of fruits, vegetables, nuts, seeds, legumes, tubers, whole grains, fish, seafood, and extra virgin olive oil.\n" +
                    "\n" +
                    "Foods such as poultry, eggs, and dairy products are to be eaten in moderation. Meanwhile, red meats are limited." +
                    "Though it’s not specifically a weight loss diet, many studies show that adopting a Mediterranean-style diet may aid weight loss.\n" +
                    "\n" +
                    "For example, an analysis of 19 studies found that people who combined the Mediterranean diet with exercise or calorie restriction lost an average of 8.8 pounds (4 kg) more than those on a control diet ",


            "Plant-based diets may help you lose weight. Vegetarianism and veganism are the most popular versions, which restrict animal products for health, ethical, and environmental reasons.\n" +
                    "\n" +
                    "However, more flexible plant-based diets also exist, such as the flexitarian diet, which is a plant-based diet that allows eating animal products in moderation.\n" +
                    "\n" +
                    "How it works: There are many types of vegetarianism, but most involve eliminating all meat, poultry, and fish. Some vegetarians may likewise avoid eggs and dairy.\n" +
                    "\n" +
                    "The vegan diet takes it a step further by restricting all animal products, as well as animal-derived products like dairy, gelatin, honey, whey, casein, and albumin.",

            "The paleo diet advocates eating the same foods that your hunter-gatherer ancestors allegedly ate.\n" +
                    "\n"+
                   "It’s based on the theory that modern diseases are linked to the Western diet, as proponents believe that the human body hasn’t evolved to process legumes, grains, and dairy.\n" +
                        "\n" +
                    "How it works: The paleo diet advocates eating whole foods, fruits, vegetables, lean meats, nuts, and seeds. It restricts the consumption of processed foods, grains, sugar, and dairy, though some less restrictive versions allow for some dairy products like cheese.\n"+
                   "For example, in one 3-week study, 14 healthy adults following a paleo diet lost an average of 5.1 pounds (2.3 kg) and reduced their waist circumference — a marker for belly fat — by an average of 0.6 inches (1.5 cm)",

            "WW, formerly Weight Watchers, is one of the most popular weight loss programs worldwide.\n" +
                    "\n" +
                    "While it doesn’t restrict any food groups, people on a WW plan must eat within their set daily points to reach their ideal weight.\n" +
                    "\n" +
                    "How it works: WW is a points-based system that assigns different foods and beverages a value, depending on their calorie, fat, and fiber contents.\n" +
                    "\n" +
                    "To reach your desired weight, you must stay within your daily point allowance." +
                    "For example, a review of 45 studies found that people who followed a WW diet lost 2.6% more weight than people who received standard counseling",};







    private List<ItemsModal> itemsModalList=new ArrayList<>();
    GridView gridView;
    gain.CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);

        for(int i=0; i<names.length;i++){

            ItemsModal itemsModal=new ItemsModal(images[i],names[i],description[i]);
            itemsModalList.add(itemsModal);
        }

        gridView = findViewById(R.id.gridview);
        customAdapter=new gain.CustomAdapter(itemsModalList,this);

        gridView.setAdapter(customAdapter);


    }

    public class CustomAdapter extends BaseAdapter {

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
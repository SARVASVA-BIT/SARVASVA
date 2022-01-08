package com.example.sarvasva.app.activities;

import static android.content.ContentValues.TAG;
import static java.lang.String.valueOf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.sarvasva.R;
import com.example.sarvasva.app.Classes.HorizontalSliderAdapter;
import com.example.sarvasva.app.fragments.LoginFragment;
import com.example.sarvasva.app.fragments.SyllabusFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SyallabusActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private Button nextBtn;

   private Spinner spinnerCourse;
   private Spinner spinnerBranch;
   private Spinner spinnerSem;
   private Spinner spinnerSubject;

   private ArrayAdapter<String>adapterCourse ,  adapterBranch , adapterSem , adapterSubject;
   private ArrayList<String> course ;
   private ArrayList<String> BTECH , BARCH , BBA ;
   private ArrayList<String> CSE , ECE , EEE , BARCHBranch , BBABranch;
   private ArrayList<String> CSEsem1 , CSEsem2 , ECEsem1 ,ECEsem2 , EEEsem1 , BARCHsem1 , BBAsem1;
   private ArrayList<String> Tensem , Sixsem , Eightsem ;

   private FirebaseFirestore firestore;

   private String courseSet , branchSet  , semSet , subjectSet ;
   private TextView courseCodeTv , courseTitleTv , module1Tv, module5Tv, module4Tv,
           module3Tv, module2Tv , referenceBookTv , textBookTv;

   private String courseCode , courseTitle , module1, module5,
           module4, module3, module2 , referenceBook , textBook ;
   private String selectedCourse,selectedBranch,selectedSubject,selectedSem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syallabus);




        firestore = FirebaseFirestore.getInstance();

        nextBtn = findViewById(R.id.nextBtn);

        courseCodeTv = findViewById(R.id.courseCodeTv);
        courseTitleTv = findViewById(R.id.courseTitleTv);
        module1Tv = findViewById(R.id.module1Tv);
        module2Tv = findViewById(R.id.module2Tv);
        module3Tv = findViewById(R.id.module3Tv);
        module4Tv = findViewById(R.id.module4Tv);
        module5Tv = findViewById(R.id.module5Tv);
        textBookTv = findViewById(R.id.textBookTv);
        referenceBookTv = findViewById(R.id.referenceBookTv);




        spinnerCourse = findViewById(R.id.spinnerCourseSpin);
        spinnerBranch = findViewById(R.id.spinnerBranchSpin);
        spinnerSem = findViewById(R.id.spinnerSem1);
        spinnerSubject = findViewById(R.id.spinnerSubject);

        course = new ArrayList<>();
        course.add("BTECH");
        course.add("BARCH");
        course.add("BBA");

        String title = "SYLLABUS";
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.primary)));



        //setting first drop down
         adapterCourse = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item , course);
         adapterCourse.setDropDownViewResource(android.R.layout.simple_spinner_item);
        adapterCourse.notifyDataSetChanged();
        spinnerCourse.setAdapter(adapterCourse);

        BTECH= new ArrayList<>();
        BTECH.add("CSE");
        BTECH.add("ECE");
        BTECH.add("IT");
        BTECH.add("MECH");
        BTECH.add("EEE");
        BTECH.add("CHEMICAL");
        BTECH.add("PRODUCTION");
        BTECH.add("BIOTECH");

        BBA = new ArrayList<>();
        BBA.add("BBA");

        BARCH = new ArrayList<>();
        BARCH.add("BARCH");



        spinnerCourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedCourse= spinnerCourse.getSelectedItem().toString().trim()+"";
                courseSet = selectedCourse;
                if (i==0)
                {
                    adapterBranch = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item , BTECH);

                }
                if (i==1)
                {
                    adapterBranch = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item , BARCH);

                }
                if (i==2)
                {
                    adapterBranch = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item , BBA);

                }
                adapterBranch.notifyDataSetChanged();
                spinnerBranch.setAdapter(adapterBranch);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        CSE = new ArrayList<>();
        CSE.add("SEM1");
        CSE.add("SEM2");
        CSE.add("SEM3");
        CSE.add("SEM4");
        CSE.add("SEM5");
        CSE.add("SEM6");
        CSE.add("SEM7");
        CSE.add("SEM8");

        ECE = new ArrayList<>();
        ECE.add("SEM1");
        ECE.add("SEM2");
        ECE.add("SEM3");
        ECE.add("SEM4");
        ECE.add("SEM5");
        ECE.add("SEM6");
        ECE.add("SEM7");
        ECE.add("SEM8");

        BARCHBranch = new ArrayList<>();
        BARCHBranch.add("SEM1");
        BARCHBranch.add("SEM2");
        BARCHBranch.add("SEM3");
        BARCHBranch.add("SEM4");
        BARCHBranch.add("SEM5");
        BARCHBranch.add("SEM6");
        BARCHBranch.add("SEM7");
        BARCHBranch.add("SEM8");
        BARCHBranch.add("SEM9");
        BARCHBranch.add("SEM10");

        spinnerBranch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedBranch = spinnerBranch.getSelectedItem().toString().trim()+"";
                branchSet = selectedBranch;
                if (selectedBranch.equalsIgnoreCase(BTECH.get(0)))
                {
                    adapterSem = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item , CSE);

                }
                if (selectedBranch.equalsIgnoreCase(BTECH.get(1)))
                {
                    adapterSem = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item , ECE);

                }
                if (selectedBranch.equalsIgnoreCase(BARCH.get(0)))
                {
                    adapterSem = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item , BARCHBranch);

                }
                adapterSem.notifyDataSetChanged();
                spinnerSem.setAdapter(adapterSem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        CSEsem1 = new ArrayList<>();
        CSEsem1.add("BECE");
        CSEsem1.add("Chemistry");
        CSEsem1.add("Mathematics I");

        CSEsem2 = new ArrayList<>();
        CSEsem2.add("Mathematics II");
        CSEsem2.add("Physics");
        CSEsem2.add("Programming for problem Solving");

        ECEsem1 = new ArrayList<>();
        ECEsem1.add("BECE");
        ECEsem1.add("Chemistry");
        ECEsem1.add("Mathematics I");

        ECEsem2 = new ArrayList<>();
        ECEsem2.add("Mathematics II");
        ECEsem2.add("Physics");
        ECEsem2.add("Programming for problem Solving");



        spinnerSem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedSem = spinnerSem.getSelectedItem().toString().trim()+"";
                semSet = selectedSem;
                if (selectedSem.equalsIgnoreCase(CSE.get(0)))
                {
                    adapterSubject = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item , CSEsem1);

                }
                if (selectedSem.equalsIgnoreCase(CSE.get(1)))
                {
                    adapterSubject = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item , CSEsem2);

                }
                if (selectedSem.equalsIgnoreCase(ECE.get(0)))
                {
                    adapterSubject = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item , ECEsem1);

                }
                if (selectedSem.equalsIgnoreCase(ECE.get(1)))
                {
                    adapterSubject = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item , ECEsem2);

                }
                adapterSubject.notifyDataSetChanged();
                spinnerSubject.setAdapter(adapterSubject);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerSubject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedSubject = spinnerSubject.getSelectedItem().toString().trim()+"";
                subjectSet = selectedSubject;

                  }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SyallabusActivity.this, SyllabusDetailActivity.class);
                intent.putExtra("course" , courseSet );
                intent.putExtra("branch" , branchSet );
                intent.putExtra("sem" , semSet );
                intent.putExtra("subject" , subjectSet );
                startActivity(intent);
            }
        });


    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
        {
            Intent intent = new Intent(this , MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
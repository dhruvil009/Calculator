package com.notebook.idealabs.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calc extends Activity {

    TextView result;

    String Display = "";
    String left = "";
    String right ="";
    int Result = 0;

    public enum Operation
    {
        Add,Subtract,Divide,Multiply,Equal
    }

    Operation Currentoperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button zero = (Button)findViewById(R.id.zero);
        Button one = (Button)findViewById(R.id.one);
        Button two = (Button)findViewById(R.id.two);
        Button three = (Button)findViewById(R.id.three);
        Button four = (Button)findViewById(R.id.four);
        Button five = (Button)findViewById(R.id.five);
        Button six = (Button)findViewById(R.id.six);
        Button seven = (Button)findViewById(R.id.seven);
        Button eight = (Button)findViewById(R.id.eight);
        Button nine = (Button)findViewById(R.id.nine);

        Button divide = (Button)findViewById(R.id.Divide);
        Button add = (Button)findViewById(R.id.Add);
        Button subtract = (Button)findViewById(R.id.Subtract);
        Button multiply = (Button)findViewById(R.id.Multiply);

        Button clear = (Button)findViewById(R.id.Clear);

        Button compute = (Button)findViewById(R.id.Calculate);

        result = (TextView)findViewById(R.id.Result);
        result.setText("");



        zero.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Display += "0";
                result.setText(Display);
            }
        });

        one.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Display += "1";
                result.setText(Display);
            }
        });

        two.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Display += "2";
                result.setText(Display);
            }
        });

        three.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Display += "3";
                result.setText(Display);
            }
        });

        four.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Display += "4";
                result.setText(Display);
            }
        });

        five.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Display += "5";
                result.setText(Display);
            }
        });

        six.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Display += "6";
                result.setText(Display);
            }
        });

        seven.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Display += "7";
                result.setText(Display);
            }
        });

        eight.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Display += "8";
                result.setText(Display);
            }
        });

        nine.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Display += "9";
                result.setText(Display);
            }
        });

        divide.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                ProcessOperation(Operation.Divide);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                ProcessOperation(Operation.Multiply);
            }
        });

        add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                ProcessOperation(Operation.Add);
            }
        });

        subtract.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                ProcessOperation(Operation.Subtract);
            }
        });

        clear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                left="";
                right="";
                Display = "";
                Result = 0;
                Currentoperation = null;
                result.setText("");
            }
        });

        compute.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                ProcessOperation(Operation.Equal);
            }
        });

    }

    void ProcessOperation(Operation operation)
    {
        if(Currentoperation!=null)
        {
            if(Display!="")
            {
                right = Display;
                Display="";

                switch (Currentoperation)
                {
                    case Add :
                        Result = Integer.parseInt(left) + Integer.parseInt(right);
                        break;
                    case Subtract:
                        Result = Integer.parseInt(left) - Integer.parseInt(right);
                        break;
                    case Multiply:
                        Result = Integer.parseInt(left) * Integer.parseInt(right);
                        break;
                    case Divide:
                        Result = Integer.parseInt(left) / Integer.parseInt(right);
                        break;
                    //default:
                      //  operation = Currentoperation;
                }

                left = String.valueOf(Result);
                result.setText(left);
            }
            Currentoperation = operation;
        }
        else
        {
            left = Display;
            Display = "";
            Currentoperation = operation;
        }
    }
}

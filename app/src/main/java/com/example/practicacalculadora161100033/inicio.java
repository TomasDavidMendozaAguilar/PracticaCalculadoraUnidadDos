package com.example.practicacalculadora161100033;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class inicio extends AppCompatActivity {
    TextView Re;
    TextView cadena;
    double n1 = 0, n2, n3;
    private boolean iguall, inicioo = true, op1, op2;
    private double momoria = 0, resultado, valor, valor2;
    long tiempo;
    private String signo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        Re = (TextView) findViewById(R.id.ver);
        TextView sig = (TextView)findViewById(R.id.ra);
        cadena = (TextView) findViewById(R.id.seguidor);
        Button raiz = (Button) findViewById(R.id.raizbtn);
        Button uno = (Button) findViewById(R.id.unooo);
        Button dos = (Button) findViewById(R.id.dosss);
        Button tres = (Button) findViewById(R.id.tresss);
        Button cuatro = (Button) findViewById(R.id.cua);
        Button cinco = (Button) findViewById(R.id.cinco);
        Button seis = (Button) findViewById(R.id.seis);
        Button siete = (Button) findViewById(R.id.sie);
        Button ocho = (Button) findViewById(R.id.och);
        Button nueve = (Button) findViewById(R.id.nue);
        Button cero = (Button) findViewById(R.id.ceroooo);
        Button cambiar = (Button) findViewById(R.id.cam);
        Button mas = (Button) findViewById(R.id.massss);
        Button menos = (Button) findViewById(R.id.menosss);
        Button multiplicacion = (Button) findViewById(R.id.multiplicacion);
        Button division = (Button) findViewById(R.id.div);
        Button punto = (Button) findViewById(R.id.puntoooo);
        Button borrar = (Button) findViewById(R.id.barrarr);
        Button igual = (Button) findViewById(R.id.igualll);

        try {
            cambiar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sig.setText("");
                    try {
                        n2 = Double.parseDouble(Re.getText().toString());
                        n3 = n1 - n2;
                        Re.setText(n3 + " ");
                    } catch (Exception e) {

                    }


                }
            });


            igual.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {


                        if(Re.getText().toString().contains("NaN")){
                            Re.setText("");
                            sig.setText("");
                        }else{
                            if(sig.getText().toString().contains("√")){
                                try{
                                    cadena.setText(" ");
                                    double raiz = Double.parseDouble(Re.getText().toString());
                                    double Ree = Math.sqrt(raiz);
                                    sig.setText("√"+Re.getText().toString());
                                    Re.setText(Ree+"");
                                }catch (Exception u){
                                    Re.setText("");
                                }

                            }else if(sig.getText().toString().contains("")){
                                sig.setText("");
                                inicioo = true;
                                op1 = true;
                                if (iguall = true) {
                                    if (signo == null) {

                                    } else {
                                        valor2 = Double.parseDouble(Re.getText().toString());
                                        cadena.setText(cadena.getText().toString() + Re.getText().toString());
                                        operaciones(valor, valor2);
                                        iguall = false;
                                    }
                                } else {
                                    Re.setText("");
                                    operaciones(valor, valor2);
                                }
                            }

                        }


                    } catch (Exception e) {

                    }

                }
            });

            borrar.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        tiempo = (Long) System.currentTimeMillis();
                        if (Re.getText().length() > 0) {
                            Re.setText(Re.getText().toString().substring(0, Re.getText().length() - 1));

                            if (Re.getText().length() == 0) {
                                cadena.setText(" ");
                                sig.setText("");
                                valor=0;
                                inicioo = true;
                            }
                        }
                    } else if (event.getAction() == MotionEvent.ACTION_UP) {

                        if (((Long) System.currentTimeMillis() - tiempo) >= 300) {
                            Re.setText("");
                            sig.setText("");
                            cadena.setText(" ");
                            valor = 0;
                            return true;
                        }

                    }


                    return false;
                }
            });


            punto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try {
                        if (Re.getText().toString().contains(".")) {


                        } else {
                            Re.setText(Re.getText() + ".");
                            inicioo = false;
                        }
                    } catch (Exception e) {

                    }


                }
            });


            division.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sig.setText("");
                    try {

                        if(Re.getText().toString().contains("NaN")){
                            Re.setText("");
                        }else{

                            iguall = true;
                            inicioo = true;
                            if (op1 = true) {



                                valor = Double.parseDouble(Re.getText().toString());
                                cadena.setText(" ");
                                cadena.setText(Re.getText().toString() + "/");
                                op1 = false;
                            } else {
                                if (op2 = true) {
                                    valor = Double.parseDouble(Re.getText().toString());
                                    cadena.setText(" ");
                                    cadena.setText(Re.getText().toString() + "/");
                                    op2 = false;
                                } else {
                                    cadena.setText(Re.getText().toString() + "/");
                                    operaciones(resultado, valor2);
                                }
                            }
                            signo = "/";

                        }


                    } catch (Exception e) {

                    }


                }
            });

            raiz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        sig.setText("√");

                    } catch (Exception e) {
                        Re.setText("");
                        sig.setText("");

                    }
                }
            });

            menos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sig.setText("");
                    try {

                        if(Re.getText().toString().contains("NaN")){
                            Re.setText("");
                        }else{
                            iguall = true;
                            inicioo = true;
                            if (op1 = true) {
                                valor = Double.parseDouble(Re.getText().toString());
                                cadena.setText(" ");
                                cadena.setText(Re.getText().toString() + "-");
                                op1 = false;
                            } else {
                                if (op2 = true) {
                                    valor = Double.parseDouble(Re.getText().toString());
                                    cadena.setText(" ");
                                    cadena.setText(Re.getText().toString() + "-");

                                    op2 = false;
                                } else {
                                    cadena.setText(Re.getText().toString() + "-");

                                    operaciones(resultado, valor2);
                                }
                            }
                            signo = "-";

                        }



                    } catch (Exception e) {
                        AlertDialog.Builder alerta = new AlertDialog.Builder(inicio.this);
                        alerta.setMessage("Debes colocar la cantidad  y cambiarla con el boton [-/+]").setNegativeButton("Aceptar", null).create().show();


                    }


                }
            });
            multiplicacion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sig.setText("");
                    try {

                        if(Re.getText().toString().contains("NaN")){
                            Re.setText("");
                        }else{
                            iguall = true;
                            inicioo = true;
                            if (op1 = true) {
                                valor = Double.parseDouble(Re.getText().toString());
                                cadena.setText("");
                                cadena.setText(Re.getText().toString() + "*");
                                op1 = false;
                            } else {
                                if (op2 = true) {
                                    valor = Double.parseDouble(Re.getText().toString());
                                    cadena.setText("");
                                    cadena.setText(Re.getText().toString() + "*");
                                    op2 = false;
                                } else {
                                    cadena.setText(Re.getText().toString() + "*");
                                    operaciones(resultado, valor2);
                                }
                            }
                            signo = "*";
                        }

                    } catch (Exception e) {

                    }

                }
            });


            mas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sig.setText("");

                    try {

                        if(Re.getText().toString().contains("NaN")){
                            Re.setText("");
                        }else{
                            iguall = true;
                            inicioo = true;
                            if (op1 = true) {
                                valor = Double.parseDouble(Re.getText().toString());
                                cadena.setText("");
                                cadena.setText(Re.getText().toString() + "+");
                                op1 = false;
                            } else {
                                if (op2 = true) {
                                    valor = Double.parseDouble(Re.getText().toString());
                                    cadena.setText("");
                                    cadena.setText(Re.getText().toString() + "+");
                                    op2 = false;
                                } else {
                                    cadena.setText(Re.getText().toString() + "+");
                                    operaciones(resultado, valor2);
                                }
                            }
                            signo = "+";
                        }

                    } catch (Exception e) {

                    }


                }
            });
            cero.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (inicioo == true) {
                        Re.setText("");
                        Re.setText("0");
                        inicioo = false;
                    } else {
                        Re.setText(Re.getText() + "0");
                    }
                }
            });
            uno.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (inicioo == true) {
                        Re.setText("");
                        Re.setText("1");
                        inicioo = false;
                    } else {
                        Re.setText(Re.getText() + "1");
                    }
                }
            });
            dos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (inicioo == true) {
                        Re.setText("");
                        Re.setText("2");
                        inicioo = false;
                    } else {
                        Re.setText(Re.getText() + "2");
                    }
                }
            });
            tres.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (inicioo == true) {
                        Re.setText("");
                        Re.setText("3");
                        inicioo = false;
                    } else {
                        Re.setText(Re.getText() + "3");
                    }
                }
            });
            cuatro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (inicioo == true) {
                        Re.setText("");
                        Re.setText("4");
                        inicioo = false;
                    } else {
                        Re.setText(Re.getText() + "4");
                    }
                }
            });
            cinco.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (inicioo == true) {
                        Re.setText("");
                        Re.setText("5");
                        inicioo = false;
                    } else {
                        Re.setText(Re.getText() + "5");
                    }
                }
            });
            seis.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (inicioo == true) {
                        Re.setText("");
                        Re.setText("6");
                        inicioo = false;
                    } else {
                        Re.setText(Re.getText() + "6");
                    }
                }
            });
            siete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (inicioo == true) {
                        Re.setText("");
                        Re.setText("7");
                        inicioo = false;
                    } else {
                        Re.setText(Re.getText() + "7");
                    }
                }
            });
            ocho.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (inicioo == true) {
                        Re.setText("");
                        Re.setText("8");
                        inicioo = false;
                    } else {
                        Re.setText(Re.getText() + "8");
                    }
                }
            });
            nueve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (inicioo == true) {
                        Re.setText("");
                        Re.setText("9");
                        inicioo = false;
                    } else {
                        Re.setText(Re.getText() + "9");
                    }

                }
            });

        } catch (Exception e) {
            AlertDialog.Builder alerta = new AlertDialog.Builder(inicio.this);
            alerta.setMessage("Haz colocado algo Erroneo").setNegativeButton("Aceptar", null).create().show();

        }


    }

    public void operaciones(double valor1, double valor2) {

        try {
            switch (signo) {
                case "+":
                    resultado = valor + valor2;
                    Re.setText(resultado + "");
                    valor1 = Double.parseDouble(Re.getText().toString());
                    break;


                case "-":
                    resultado = valor - valor2;
                    Re.setText(resultado + "");
                    valor1 = Double.parseDouble(Re.getText().toString());
                    break;


                case "*":
                    resultado = valor * valor2;
                    Re.setText(resultado + "");
                    valor1 = Double.parseDouble(Re.getText().toString());
                    break;


                case "/":

                    if (valor2 == 0) {
                        Re.setText("Error");
                    } else {
                        resultado = valor / valor2;
                        Re.setText(resultado + "");
                        valor1 = Double.parseDouble(Re.getText().toString());
                        break;
                    }
            }

            signo = null;
            //   signo = "";
        } catch (Exception e) {
            AlertDialog.Builder alerta = new AlertDialog.Builder(inicio.this);
            alerta.setMessage("Haz colocado algo Erroneo").setNegativeButton("Aceptar", null).create().show();

        }

    }


}
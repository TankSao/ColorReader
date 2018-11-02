# ColorReader
一款简单的读色器，可用于颜色选择</br>
![image](https://github.com/TankSao/ColorReader/blob/master/image/image.png)</br>
关键代码：</br>
``` Android

 img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int x = (int) event.getX();

                int y = (int) event.getY();

                bitmap = img.getDrawingCache();

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    int color = bitmap.getPixel(x, y);
                    int r = Color.red(color);
                    int g = Color.green(color);
                    int b = Color.blue(color);
                    int a = Color.alpha(color);
                    Log.i("rgb", "r=" + r + ",g=" + g + ",b=" + b+",a="+a);
                    bg.setBackgroundColor(Color.rgb(r,g,b));
                }
                return true;
            }
        });

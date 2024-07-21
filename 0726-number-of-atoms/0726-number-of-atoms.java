class Pair{
    String str;
    long freq;

    Pair(String str, long freq){
        this.str = str;
        this.freq = freq;
    }
}
class Solution {
    public String countOfAtoms(String s) {
        Stack<Pair> st = new Stack<>();

        int n = s.length();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch=='(') st.push(new Pair(ch+"",-1));
            else if(ch>='A' && ch<='Z'){
                String x = ch+"";
                int j = i+1;
                while(j<n && s.charAt(j)>='a' && s.charAt(j)<='z'){
                    x = x+s.charAt(j);
                    j++;
                }
                
                String num = "";
                if(j<n && s.charAt(j)>='0' && s.charAt(j)<='9'){
                    while(j<n && s.charAt(j)>='0' && s.charAt(j)<='9'){
                        num+=s.charAt(j);
                        j++;
                    }
                }
                if(num.equals("")){
                    st.push(new Pair(x,1));
                }else{
                    st.push(new Pair(x,Long.valueOf(num)));
                }
                  //  System.out.println(x+" "+num);
                i = j-1;
            }else{
                String num = "";
                int j = i+1;
                while(j<n && s.charAt(j)>='0' && s.charAt(j)<='9'){
                    num+=s.charAt(j);
                    j++;
                }

                long x = -1;
                if(num.equals("")) x = 1;
                else x = Long.valueOf(num);
                i = j-1;
                ArrayList<Pair> arr = new ArrayList<>();
                while(st.size()!=0 && !st.peek().str.equals("(")){
                    Pair p = st.pop();
                    arr.add(new Pair(p.str,p.freq*x));
                }
               
                if(st.size()!=0) st.pop();
              
                for(var k : arr){
                    st.push(k);
                } 
            }
        }

        HashMap<String,Long> hp = new HashMap<>();
        while(st.size()!=0){
            Pair p = st.pop();
            hp.put(p.str,hp.getOrDefault(p.str,0L)+p.freq);
        }

        System.out.println(hp);

        ArrayList<Pair> arr = new ArrayList<>();
        for(var a : hp.keySet()) arr.add(new Pair(a,hp.get(a)));

        Collections.sort(arr,(a,b)->a.str.compareTo(b.str));
        String ans = "";
        for(var a : arr){
            ans = ans+a.str;
            if(a.freq!=1){
                ans = ans+String.valueOf(a.freq);
            }
        }
        return ans;

    }
}
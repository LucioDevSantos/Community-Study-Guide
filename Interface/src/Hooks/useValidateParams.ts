
import { apiSpring } from "../Services/api";


const useValidateParams = async (id: number)=>{

     const response = await apiSpring.get(`/community/${id}`)

     if(response == null){
        return 0
     }

     return response
}

export default useValidateParams



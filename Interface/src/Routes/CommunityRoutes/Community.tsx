import { useLocation, useParams } from "react-router-dom"




export default function Community(){

const { id } = useParams()
const locateData = useLocation()

const comData = locateData.state || {}
    
    return(
        <>
        
        <div>
            <h4>
                id: {comData.id}
            </h4>
            <header>
                <h1>
                    {comData.name}
                </h1>
            <p>
                Code: {id}
            </p>


            </header>
        </div>
        </>
    )
}
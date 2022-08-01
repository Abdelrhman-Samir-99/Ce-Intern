import React from "react";

const MovieCard = ({title, poster_path, overview, vote_average}) => {
    return (
        <div>
            <img sr = "https://www.google.com/search?q=image&sxsrf=ALiCzsZFGwTm7E8hYFNCSCRzxWykM9Gyig:1659354856074&tbm=isch&source=iu&ictx=1&vet=1&fir=DH7p1w2o_fIU8M%252CBa_eiczVaD9-zM%252C_%253BvltR97mKu_bs0M%252Cgcs3oZzNDoclIM%252C_%253BL2hxXuK7NBWJmM%252C0JWe7yDOKrVFAM%252C_%253BqXynBYpZpHkhWM%252C4O2GvGuD-Cf09M%252C_%253Bn5hAWsQ-sgKo_M%252C-UStXW0dQEx4SM%252C_%253BkwgHAQqTiLQXLM%252C2bZLA8JdC6ZaTM%252C_%253BQOZymhPf48LDYM%252CLOSptVP0p_ZwUM%252C_%253BBx81dUgHmqLhzM%252CNMmM-IXyCkU2hM%252C_%253BI47E5zEVdN-joM%252CZUlRqjbz2TDaIM%252C_%253B2nDXavJs9DoKTM%252CB51x0PBR9KNzvM%252C_%253B-VCM1w56w6u5VM%252CaVwfeogQqK1XmM%252C_%253B2DNOEjVi-CBaYM%252CAOz9-XMe1ixZJM%252C_&usg=AI4_-kSqRSrzHiBtDj_B1foGf3K_QKZ3Ow&sa=X&ved=2ahUKEwitq4LGyqX5AhWW0oUKHcnkAsEQ9QF6BAgFEAE&biw=1920&bih=969&dpr=1#imgrc=DH7p1w2o_fIU8M" />
            <div>
                <h3>{title}</h3>
                <span>{vote_average}</span>
            </div>
        </div>
    );
}

export default MovieCard;
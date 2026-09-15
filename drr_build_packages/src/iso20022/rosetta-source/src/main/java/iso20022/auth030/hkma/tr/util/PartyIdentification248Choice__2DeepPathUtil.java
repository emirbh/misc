package iso20022.auth030.hkma.tr.util;

import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.hkma.tr.LegalPersonIdentification1__2;
import iso20022.auth030.hkma.tr.NaturalPersonIdentification3__1;
import iso20022.auth030.hkma.tr.PartyIdentification248Choice__2;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class PartyIdentification248Choice__2DeepPathUtil {
    public String chooseCtry(PartyIdentification248Choice__2 partyIdentification248Choice__2) {
        final MapperS<LegalPersonIdentification1__2> lgl = MapperS.of(partyIdentification248Choice__2).<LegalPersonIdentification1__2>map("getLgl", _partyIdentification248Choice__2 -> _partyIdentification248Choice__2.getLgl());
        if (exists(lgl).getOrDefault(false)) {
            return lgl.<String>map("getCtry", legalPersonIdentification1__2 -> legalPersonIdentification1__2.getCtry()).get();
        }
        final MapperS<NaturalPersonIdentification3__1> ntrl = MapperS.of(partyIdentification248Choice__2).<NaturalPersonIdentification3__1>map("getNtrl", _partyIdentification248Choice__2 -> _partyIdentification248Choice__2.getNtrl());
        if (exists(ntrl).getOrDefault(false)) {
            return ntrl.<String>map("getCtry", naturalPersonIdentification3__1 -> naturalPersonIdentification3__1.getCtry()).get();
        }
        return null;
    }

}

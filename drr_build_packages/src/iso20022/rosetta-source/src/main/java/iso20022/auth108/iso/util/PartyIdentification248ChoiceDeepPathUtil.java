package iso20022.auth108.iso.util;

import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth108.iso.LegalPersonIdentification1;
import iso20022.auth108.iso.NaturalPersonIdentification3;
import iso20022.auth108.iso.PartyIdentification248Choice;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class PartyIdentification248ChoiceDeepPathUtil {
    public String chooseCtry(PartyIdentification248Choice partyIdentification248Choice) {
        final MapperS<LegalPersonIdentification1> lgl = MapperS.of(partyIdentification248Choice).<LegalPersonIdentification1>map("getLgl", _partyIdentification248Choice -> _partyIdentification248Choice.getLgl());
        if (exists(lgl).getOrDefault(false)) {
            return lgl.<String>map("getCtry", legalPersonIdentification1 -> legalPersonIdentification1.getCtry()).get();
        }
        final MapperS<NaturalPersonIdentification3> ntrl = MapperS.of(partyIdentification248Choice).<NaturalPersonIdentification3>map("getNtrl", _partyIdentification248Choice -> _partyIdentification248Choice.getNtrl());
        if (exists(ntrl).getOrDefault(false)) {
            return ntrl.<String>map("getCtry", naturalPersonIdentification3 -> naturalPersonIdentification3.getCtry()).get();
        }
        return null;
    }

}

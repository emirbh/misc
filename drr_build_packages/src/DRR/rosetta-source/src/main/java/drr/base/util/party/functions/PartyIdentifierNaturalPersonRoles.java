package drr.base.util.party.functions;

import cdm.base.staticdata.party.NaturalPersonRoleEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.ArrayList;
import java.util.List;


@ImplementedBy(PartyIdentifierNaturalPersonRoles.PartyIdentifierNaturalPersonRolesDefault.class)
public abstract class PartyIdentifierNaturalPersonRoles implements RosettaFunction {

	/**
	* @return roles 
	*/
	public List<NaturalPersonRoleEnum> evaluate() {
		List<NaturalPersonRoleEnum> roles = doEvaluate();
		
		return roles;
	}

	protected abstract List<NaturalPersonRoleEnum> doEvaluate();

	public static class PartyIdentifierNaturalPersonRolesDefault extends PartyIdentifierNaturalPersonRoles {
		@Override
		protected List<NaturalPersonRoleEnum> doEvaluate() {
			List<NaturalPersonRoleEnum> roles = new ArrayList<>();
			return assignOutput(roles);
		}
		
		protected List<NaturalPersonRoleEnum> assignOutput(List<NaturalPersonRoleEnum> roles) {
			roles.addAll(MapperC.<NaturalPersonRoleEnum>of(MapperS.of(NaturalPersonRoleEnum.BUYER), MapperS.of(NaturalPersonRoleEnum.SELLER)).getMulti());
			
			return roles;
		}
	}
}

package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.EntityIdentifierTypeEnum;
import cdm.ingest.fpml.confirmation.common.functions.StringContains;
import cdm.ingest.fpml.confirmation.other.functions.MapPartyIdentifierTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;


@ImplementedBy(MapEntityIdentifierTypeEnum.MapEntityIdentifierTypeEnumDefault.class)
public abstract class MapEntityIdentifierTypeEnum implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPartyIdentifierTypeEnum mapPartyIdentifierTypeEnum;
	@Inject protected StringContains stringContains;

	/**
	* @param productIdScheme 
	* @return source 
	*/
	public EntityIdentifierTypeEnum evaluate(String productIdScheme) {
		EntityIdentifierTypeEnum source = doEvaluate(productIdScheme);
		
		return source;
	}

	protected abstract EntityIdentifierTypeEnum doEvaluate(String productIdScheme);

	public static class MapEntityIdentifierTypeEnumDefault extends MapEntityIdentifierTypeEnum {
		@Override
		protected EntityIdentifierTypeEnum doEvaluate(String productIdScheme) {
			EntityIdentifierTypeEnum source = null;
			return assignOutput(source, productIdScheme);
		}
		
		protected EntityIdentifierTypeEnum assignOutput(EntityIdentifierTypeEnum source, String productIdScheme) {
			final Boolean boolean0 = stringContains.evaluate(productIdScheme, "-id-RED-");
			final EntityIdentifierTypeEnum ifThenElseResult;
			if ((boolean0 == null ? false : boolean0)) {
				ifThenElseResult = EntityIdentifierTypeEnum.REDID;
			} else {
				final Boolean boolean1 = stringContains.evaluate(productIdScheme, "iso3166");
				if ((boolean1 == null ? false : boolean1)) {
					ifThenElseResult = EntityIdentifierTypeEnum.COUNTRY_CODE;
				} else {
					ifThenElseResult = EntityIdentifierTypeEnum.OTHER;
				}
			}
			source = MapperS.of(mapPartyIdentifierTypeEnum.evaluate(productIdScheme)).checkedMap("to-enum", e -> EntityIdentifierTypeEnum.valueOf(e.name()), IllegalArgumentException.class).getOrDefault(ifThenElseResult);
			
			return source;
		}
	}
}

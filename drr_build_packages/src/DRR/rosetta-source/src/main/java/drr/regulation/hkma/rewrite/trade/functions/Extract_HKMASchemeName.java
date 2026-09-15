package drr.regulation.hkma.rewrite.trade.functions;

import cdm.base.staticdata.party.PartyIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.HKTRPartyScheme;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Extract_HKMASchemeName.Extract_HKMASchemeNameDefault.class)
public abstract class Extract_HKMASchemeName implements RosettaFunction {

	/**
	* @param partyIdentifier 
	* @return schmeNm 
	*/
	public HKTRPartyScheme evaluate(PartyIdentifier partyIdentifier) {
		HKTRPartyScheme schmeNm = doEvaluate(partyIdentifier);
		
		return schmeNm;
	}

	protected abstract HKTRPartyScheme doEvaluate(PartyIdentifier partyIdentifier);

	public static class Extract_HKMASchemeNameDefault extends Extract_HKMASchemeName {
		@Override
		protected HKTRPartyScheme doEvaluate(PartyIdentifier partyIdentifier) {
			HKTRPartyScheme schmeNm = null;
			return assignOutput(schmeNm, partyIdentifier);
		}
		
		protected HKTRPartyScheme assignOutput(HKTRPartyScheme schmeNm, PartyIdentifier partyIdentifier) {
			final MapperS<FieldWithMetaString> thenArg = MapperS.of(partyIdentifier).<FieldWithMetaString>map("getIdentifier", _partyIdentifier -> _partyIdentifier.getIdentifier());
			schmeNm = thenArg
				.mapSingleToItem(item -> {
					if (areEqual(item.map("getMeta", a->a.getMeta()).map("getScheme", a->a.getScheme()), MapperS.of("http://www.fpml.org/coding-scheme/external/hktr-business-registration-number"), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(HKTRPartyScheme.BRNO);
					}
					if (areEqual(item.map("getMeta", a->a.getMeta()).map("getScheme", a->a.getScheme()), MapperS.of("http://www.fpml.org/coding-scheme/external/hktr-certificate-of-incorporation-number-certificate-of-registration-number"), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(HKTRPartyScheme.CICR);
					}
					if (areEqual(item.map("getMeta", a->a.getMeta()).map("getScheme", a->a.getScheme()), MapperS.of("http://www.fpml.org/coding-scheme/external/hktr-unique-business-identifier"), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(HKTRPartyScheme.UBIN);
					}
					if (areEqual(item.map("getMeta", a->a.getMeta()).map("getScheme", a->a.getScheme()), MapperS.of("http://www.fpml.org/coding-scheme/external/hktr-user-defined-code"), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(HKTRPartyScheme.USDC);
					}
					if (areEqual(item.map("getMeta", a->a.getMeta()).map("getScheme", a->a.getScheme()), MapperS.of("http://www.fpml.org/coding-scheme/external/hktr-transactional-entity-id"), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(HKTRPartyScheme.TRID);
					}
					return MapperS.<HKTRPartyScheme>ofNull();
				}).get();
			
			return schmeNm;
		}
	}
}

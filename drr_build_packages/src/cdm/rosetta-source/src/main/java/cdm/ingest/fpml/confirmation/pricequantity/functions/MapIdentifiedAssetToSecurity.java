package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.staticdata.asset.common.DebtEconomics;
import cdm.base.staticdata.asset.common.DebtSeniorityEnum;
import cdm.base.staticdata.asset.common.DebtType;
import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.base.staticdata.asset.common.Security;
import cdm.ingest.fpml.confirmation.party.functions.MapExchangeIdToLegalEntity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.IdentifiedAsset;
import fpml.consolidated.shared.ExchangeId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapIdentifiedAssetToSecurity.MapIdentifiedAssetToSecurityDefault.class)
public abstract class MapIdentifiedAssetToSecurity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetIdentifierList mapAssetIdentifierList;
	@Inject protected MapExchangeIdToLegalEntity mapExchangeIdToLegalEntity;

	/**
	* @param fpmlIdentifiedAsset 
	* @param fpmlExchangeId 
	* @param fpmlRelatedExchangeId 
	* @param instrumentType 
	* @param seniority 
	* @return security 
	*/
	public Security evaluate(IdentifiedAsset fpmlIdentifiedAsset, ExchangeId fpmlExchangeId, List<? extends ExchangeId> fpmlRelatedExchangeId, InstrumentTypeEnum instrumentType, String seniority) {
		Security.SecurityBuilder securityBuilder = doEvaluate(fpmlIdentifiedAsset, fpmlExchangeId, fpmlRelatedExchangeId, instrumentType, seniority);
		
		final Security security;
		if (securityBuilder == null) {
			security = null;
		} else {
			security = securityBuilder.build();
			objectValidator.validate(Security.class, security);
		}
		
		return security;
	}

	protected abstract Security.SecurityBuilder doEvaluate(IdentifiedAsset fpmlIdentifiedAsset, ExchangeId fpmlExchangeId, List<? extends ExchangeId> fpmlRelatedExchangeId, InstrumentTypeEnum instrumentType, String seniority);

	public static class MapIdentifiedAssetToSecurityDefault extends MapIdentifiedAssetToSecurity {
		@Override
		protected Security.SecurityBuilder doEvaluate(IdentifiedAsset fpmlIdentifiedAsset, ExchangeId fpmlExchangeId, List<? extends ExchangeId> fpmlRelatedExchangeId, InstrumentTypeEnum instrumentType, String seniority) {
			if (fpmlRelatedExchangeId == null) {
				fpmlRelatedExchangeId = Collections.emptyList();
			}
			Security.SecurityBuilder security = Security.builder();
			return assignOutput(security, fpmlIdentifiedAsset, fpmlExchangeId, fpmlRelatedExchangeId, instrumentType, seniority);
		}
		
		protected Security.SecurityBuilder assignOutput(Security.SecurityBuilder security, IdentifiedAsset fpmlIdentifiedAsset, ExchangeId fpmlExchangeId, List<? extends ExchangeId> fpmlRelatedExchangeId, InstrumentTypeEnum instrumentType, String seniority) {
			Boolean ifThenElseResult = null;
			if (exists(MapperS.of(fpmlExchangeId)).getOrDefault(false)) {
				ifThenElseResult = true;
			}
			final DebtEconomics debtEconomics = DebtEconomics.builder()
				.setDebtSeniority(MapperS.of(seniority).checkedMap("to-enum", DebtSeniorityEnum::fromDisplayName, IllegalArgumentException.class).get())
				.build();
			security = toBuilder(Security.builder()
				.setIdentifier(new ArrayList(mapAssetIdentifierList.evaluate(fpmlIdentifiedAsset)))
				.setIsExchangeListed(ifThenElseResult)
				.setExchange(MapperS.of(fpmlExchangeId)
					.mapSingleToItem(item -> MapperS.of(mapExchangeIdToLegalEntity.evaluate(item.get()))).get())
				.setRelatedExchange(MapperC.<ExchangeId>of(fpmlRelatedExchangeId)
					.mapItem(item -> MapperS.of(mapExchangeIdToLegalEntity.evaluate(item.get()))).getMulti())
				.setInstrumentType(instrumentType)
				.setDebtType(DebtType.builder()
					.setDebtEconomics((debtEconomics == null ? Collections.<DebtEconomics>emptyList() : Collections.singletonList(debtEconomics)))
					.build())
				.build());
			
			return Optional.ofNullable(security)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

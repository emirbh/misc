package drr.base.margin.functions;

import cdm.event.common.CollateralBalance;
import cdm.event.common.CollateralPortfolio;
import cdm.event.common.metafields.ReferenceWithMetaCollateralPortfolio;
import cdm.legaldocumentation.common.AgreementName;
import cdm.legaldocumentation.common.LegalAgreement;
import cdm.legaldocumentation.common.LegalAgreementIdentification;
import cdm.legaldocumentation.common.metafields.ReferenceWithMetaLegalAgreement;
import cdm.product.collateral.Collateral;
import cdm.product.collateral.CollateralMarginTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.margin.CollateralDetails;
import drr.base.margin.ReportableCollateralBase;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetCollateralBalancesForMarginType.GetCollateralBalancesForMarginTypeDefault.class)
public abstract class GetCollateralBalancesForMarginType implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param reportableCollateral 
	* @param marginType 
	* @return collateralBalances 
	*/
	public List<? extends CollateralBalance> evaluate(ReportableCollateralBase reportableCollateral, CollateralMarginTypeEnum marginType) {
		List<CollateralBalance.CollateralBalanceBuilder> collateralBalancesBuilder = doEvaluate(reportableCollateral, marginType);
		
		final List<? extends CollateralBalance> collateralBalances;
		if (collateralBalancesBuilder == null) {
			collateralBalances = null;
		} else {
			collateralBalances = collateralBalancesBuilder.stream().map(CollateralBalance::build).collect(Collectors.toList());
			objectValidator.validate(CollateralBalance.class, collateralBalances);
		}
		
		return collateralBalances;
	}

	protected abstract List<CollateralBalance.CollateralBalanceBuilder> doEvaluate(ReportableCollateralBase reportableCollateral, CollateralMarginTypeEnum marginType);

	public static class GetCollateralBalancesForMarginTypeDefault extends GetCollateralBalancesForMarginType {
		@Override
		protected List<CollateralBalance.CollateralBalanceBuilder> doEvaluate(ReportableCollateralBase reportableCollateral, CollateralMarginTypeEnum marginType) {
			List<CollateralBalance.CollateralBalanceBuilder> collateralBalances = new ArrayList<>();
			return assignOutput(collateralBalances, reportableCollateral, marginType);
		}
		
		protected List<CollateralBalance.CollateralBalanceBuilder> assignOutput(List<CollateralBalance.CollateralBalanceBuilder> collateralBalances, ReportableCollateralBase reportableCollateral, CollateralMarginTypeEnum marginType) {
			final MapperC<ReferenceWithMetaCollateralPortfolio> thenArg0 = MapperS.of(reportableCollateral).<CollateralDetails>map("getCollateralDetails", reportableCollateralBase -> reportableCollateralBase.getCollateralDetails()).<Collateral>map("getCollateral", collateralDetails -> collateralDetails.getCollateral()).<ReferenceWithMetaCollateralPortfolio>mapC("getCollateralPortfolio", collateral -> collateral.getCollateralPortfolio())
				.filterItemNullSafe(item -> areEqual(item.<CollateralPortfolio>map("Type coercion", referenceWithMetaCollateralPortfolio -> referenceWithMetaCollateralPortfolio == null ? null : referenceWithMetaCollateralPortfolio.getValue()).<ReferenceWithMetaLegalAgreement>map("getLegalAgreement", collateralPortfolio -> collateralPortfolio.getLegalAgreement()).<LegalAgreement>map("Type coercion", referenceWithMetaLegalAgreement -> referenceWithMetaLegalAgreement == null ? null : referenceWithMetaLegalAgreement.getValue()).<LegalAgreementIdentification>map("getLegalAgreementIdentification", legalAgreement -> legalAgreement.getLegalAgreementIdentification()).<AgreementName>map("getAgreementName", legalAgreementIdentification -> legalAgreementIdentification.getAgreementName()).<CollateralMarginTypeEnum>map("getCreditSupportAgreementMarginType", agreementName -> agreementName.getCreditSupportAgreementMarginType()), MapperS.of(marginType), CardinalityOperator.All).get());
			final MapperListOfLists<CollateralBalance> thenArg1 = thenArg0
				.mapItemToList(item -> item.<CollateralPortfolio>map("Type coercion", referenceWithMetaCollateralPortfolio -> referenceWithMetaCollateralPortfolio == null ? null : referenceWithMetaCollateralPortfolio.getValue()).<CollateralBalance>mapC("getCollateralBalance", collateralPortfolio -> collateralPortfolio.getCollateralBalance()));
			collateralBalances.addAll(toBuilder(thenArg1
				.flattenList().getMulti()));
			
			return Optional.ofNullable(collateralBalances)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}

package cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import cdm.ingest.fpml.confirmation.party.functions.MapLegalEntity;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapIndexIdToAssetIdentifier;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapIndexNameToAssetIdentifier;
import cdm.observable.asset.CreditIndex;
import cdm.product.asset.CreditSeniorityEnum;
import cdm.product.asset.IndexAnnexSourceEnum;
import cdm.product.asset.ReferenceInformation;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.cd.IndexAnnexSource;
import fpml.consolidated.cd.IndexId;
import fpml.consolidated.cd.IndexName;
import fpml.consolidated.cd.IndexReferenceInformation;
import fpml.consolidated.cd.SettledEntityMatrix;
import fpml.consolidated.cd.Tranche;
import fpml.consolidated.shared.CreditSeniority;
import fpml.consolidated.shared.LegalEntity;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCreditIndex.MapCreditIndexDefault.class)
public abstract class MapCreditIndex implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapIndexIdToAssetIdentifier mapIndexIdToAssetIdentifier;
	@Inject protected MapIndexNameToAssetIdentifier mapIndexNameToAssetIdentifier;
	@Inject protected MapLegalEntity mapLegalEntity;
	@Inject protected MapSettledEntityMatrix mapSettledEntityMatrix;
	@Inject protected MapStringWithScheme mapStringWithScheme;
	@Inject protected MapTranche mapTranche;

	/**
	* @param fpmlIndexReferenceInformation 
	* @return creditIndex 
	*/
	public CreditIndex evaluate(IndexReferenceInformation fpmlIndexReferenceInformation) {
		CreditIndex.CreditIndexBuilder creditIndexBuilder = doEvaluate(fpmlIndexReferenceInformation);
		
		final CreditIndex creditIndex;
		if (creditIndexBuilder == null) {
			creditIndex = null;
		} else {
			creditIndex = creditIndexBuilder.build();
			objectValidator.validate(CreditIndex.class, creditIndex);
		}
		
		return creditIndex;
	}

	protected abstract CreditIndex.CreditIndexBuilder doEvaluate(IndexReferenceInformation fpmlIndexReferenceInformation);

	protected abstract MapperS<? extends IndexName> indexName(IndexReferenceInformation fpmlIndexReferenceInformation);

	protected abstract MapperC<? extends IndexId> indexId(IndexReferenceInformation fpmlIndexReferenceInformation);

	public static class MapCreditIndexDefault extends MapCreditIndex {
		@Override
		protected CreditIndex.CreditIndexBuilder doEvaluate(IndexReferenceInformation fpmlIndexReferenceInformation) {
			CreditIndex.CreditIndexBuilder creditIndex = CreditIndex.builder();
			return assignOutput(creditIndex, fpmlIndexReferenceInformation);
		}
		
		protected CreditIndex.CreditIndexBuilder assignOutput(CreditIndex.CreditIndexBuilder creditIndex, IndexReferenceInformation fpmlIndexReferenceInformation) {
			if (exists(MapperS.of(fpmlIndexReferenceInformation)).getOrDefault(false)) {
				creditIndex = toBuilder(CreditIndex.builder()
					.setIdentifier(MapperC.<AssetIdentifier>of(indexName(fpmlIndexReferenceInformation)
						.mapSingleToItem(item -> MapperS.of(mapIndexNameToAssetIdentifier.evaluate(item.get()))), indexId(fpmlIndexReferenceInformation)
						.mapItem(item -> MapperS.of(mapIndexIdToAssetIdentifier.evaluate(item.get())))).getMulti())
					.setName(mapStringWithScheme.evaluate(MapperS.of(fpmlIndexReferenceInformation).<IndexName>map("getIndexName", indexReferenceInformation -> indexReferenceInformation.getIndexName()).<String>map("getValue", _indexName -> _indexName.getValue()).get(), MapperS.of(fpmlIndexReferenceInformation).<IndexName>map("getIndexName", indexReferenceInformation -> indexReferenceInformation.getIndexName()).<String>map("getIndexNameScheme", _indexName -> _indexName.getIndexNameScheme()).get()))
					.setProvider(null)
					.setAssetClass(AssetClassEnum.CREDIT)
					.setIndexSeries(MapperS.of(fpmlIndexReferenceInformation).<Integer>map("getIndexSeries", indexReferenceInformation -> indexReferenceInformation.getIndexSeries()).get())
					.setIndexAnnexVersion(MapperS.of(fpmlIndexReferenceInformation).<Integer>map("getIndexAnnexVersion", indexReferenceInformation -> indexReferenceInformation.getIndexAnnexVersion()).get())
					.setIndexAnnexDate(MapperS.of(fpmlIndexReferenceInformation).<ZonedDateTime>map("getIndexAnnexDate", indexReferenceInformation -> indexReferenceInformation.getIndexAnnexDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
					.setIndexAnnexSourceValue(MapperS.of(fpmlIndexReferenceInformation).<IndexAnnexSource>map("getIndexAnnexSource", indexReferenceInformation -> indexReferenceInformation.getIndexAnnexSource()).<String>map("getValue", indexAnnexSource -> indexAnnexSource.getValue()).checkedMap("to-enum", IndexAnnexSourceEnum::fromDisplayName, IllegalArgumentException.class).get())
					.setExcludedReferenceEntity(MapperS.of(fpmlIndexReferenceInformation).<LegalEntity>mapC("getExcludedReferenceEntity", indexReferenceInformation -> indexReferenceInformation.getExcludedReferenceEntity())
						.mapItem(item -> MapperS.of(ReferenceInformation.builder()
							.setReferenceEntity(mapLegalEntity.evaluate(item.get()))
							.build())).getMulti())
					.setTranche(mapTranche.evaluate(MapperS.of(fpmlIndexReferenceInformation).<Tranche>map("getTranche", indexReferenceInformation -> indexReferenceInformation.getTranche()).get()))
					.setSettledEntityMatrix(mapSettledEntityMatrix.evaluate(MapperS.of(fpmlIndexReferenceInformation).<SettledEntityMatrix>map("getSettledEntityMatrix", indexReferenceInformation -> indexReferenceInformation.getSettledEntityMatrix()).get()))
					.setIndexFactor(MapperS.of(fpmlIndexReferenceInformation).<BigDecimal>map("getIndexFactor", indexReferenceInformation -> indexReferenceInformation.getIndexFactor()).get())
					.setSeniority(MapperS.of(fpmlIndexReferenceInformation).<CreditSeniority>map("getSeniority", indexReferenceInformation -> indexReferenceInformation.getSeniority()).<String>map("getValue", creditSeniority -> creditSeniority.getValue()).checkedMap("to-enum", CreditSeniorityEnum::fromDisplayName, IllegalArgumentException.class).get())
					.build());
			} else {
				creditIndex = null;
			}
			
			return Optional.ofNullable(creditIndex)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends IndexName> indexName(IndexReferenceInformation fpmlIndexReferenceInformation) {
			return MapperS.of(fpmlIndexReferenceInformation).<IndexName>map("getIndexName", indexReferenceInformation -> indexReferenceInformation.getIndexName());
		}
		
		@Override
		protected MapperC<? extends IndexId> indexId(IndexReferenceInformation fpmlIndexReferenceInformation) {
			return MapperS.of(fpmlIndexReferenceInformation).<IndexId>mapC("getIndexId", indexReferenceInformation -> indexReferenceInformation.getIndexId()).getMulti().isEmpty() ? MapperS.of(fpmlIndexReferenceInformation).<IndexId>mapC("getIndexId", indexReferenceInformation -> indexReferenceInformation.getIndexId()) : MapperS.of(fpmlIndexReferenceInformation).<IndexId>mapC("getIndexId", indexReferenceInformation -> indexReferenceInformation.getIndexId());
		}
	}
}

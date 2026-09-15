package drr.regulation.common;

import cdm.event.common.TradeIdentifier;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import drr.regulation.common.meta.TransactionInformationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies jurisdiction-specific information regarding the transaction.
 * @version 7.7.0
 */
@RosettaDataType(value="TransactionInformation", builder=TransactionInformation.TransactionInformationBuilderImpl.class, version="7.7.0")
@RuneDataType(value="TransactionInformation", model="drr", builder=TransactionInformation.TransactionInformationBuilderImpl.class, version="7.7.0")
public interface TransactionInformation extends RosettaModelObject {

	TransactionInformationMeta metaData = new TransactionInformationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identifier to use specifically in the context of reporting to a specific regime.
	 */
	TradeIdentifier getTransactionIdentifier();
	/**
	 * Identifier of the prior transaction.
	 */
	TradeIdentifier getPriorTransactionIdentifier();
	/**
	 * Describes the execution venue where the trade is executed.
	 */
	ReportableExecutionVenue getReportableExecutionVenue();
	/**
	 * Specifies whether the sender of this trade considers it to be a large notional trade or block trade for reporting purposes, and thus eligible for delayed public reporting. Normally this will only be applicable for off-facility trades.
	 */
	Boolean getLargeSizeTrade();
	/**
	 * Specifies the approximate duration of the contract in the context of commoditiy trading. Exact boundaries of each value have not been precisely defined by so far. This attribute is expected to be removed when values exact definitions of values emerge and a functional assessment of duration - based upon start and end dates and times - can be implemented.
	 */
	CommodityTimeUnitEnum getDuration();
	/**
	 * Whether the financial instrument is admitted to trading, or traded on a trading venue or for which a request for admission was made.
	 */
	TradableOnTradingVenueEnum getTradableOnTradingVenue();
	/**
	 * Indicator of whether the product underlier of the reportable trade is traded on a trading venue.
	 */
	Boolean getUnderlierTradedOnTradingVenue();
	/**
	 * For a platform (e.g. exchange) traded underlying asset, the platform on which the asset is traded.
	 */
	String getUnderlierAssetTradingPlatformIdentifier();
	/**
	 * Unique internal identifier created and used by the user to identify the transaction.
	 */
	String getInternalTradeIdentifier();

	/*********************** Build Methods  ***********************/
	TransactionInformation build();
	
	TransactionInformation.TransactionInformationBuilder toBuilder();
	
	static TransactionInformation.TransactionInformationBuilder builder() {
		return new TransactionInformation.TransactionInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TransactionInformation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TransactionInformation> getType() {
		return TransactionInformation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("transactionIdentifier"), processor, TradeIdentifier.class, getTransactionIdentifier());
		processRosetta(path.newSubPath("priorTransactionIdentifier"), processor, TradeIdentifier.class, getPriorTransactionIdentifier());
		processRosetta(path.newSubPath("reportableExecutionVenue"), processor, ReportableExecutionVenue.class, getReportableExecutionVenue());
		processor.processBasic(path.newSubPath("largeSizeTrade"), Boolean.class, getLargeSizeTrade(), this);
		processor.processBasic(path.newSubPath("duration"), CommodityTimeUnitEnum.class, getDuration(), this);
		processor.processBasic(path.newSubPath("tradableOnTradingVenue"), TradableOnTradingVenueEnum.class, getTradableOnTradingVenue(), this);
		processor.processBasic(path.newSubPath("underlierTradedOnTradingVenue"), Boolean.class, getUnderlierTradedOnTradingVenue(), this);
		processor.processBasic(path.newSubPath("underlierAssetTradingPlatformIdentifier"), String.class, getUnderlierAssetTradingPlatformIdentifier(), this);
		processor.processBasic(path.newSubPath("internalTradeIdentifier"), String.class, getInternalTradeIdentifier(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TransactionInformationBuilder extends TransactionInformation, RosettaModelObjectBuilder {
		TradeIdentifier.TradeIdentifierBuilder getOrCreateTransactionIdentifier();
		@Override
		TradeIdentifier.TradeIdentifierBuilder getTransactionIdentifier();
		TradeIdentifier.TradeIdentifierBuilder getOrCreatePriorTransactionIdentifier();
		@Override
		TradeIdentifier.TradeIdentifierBuilder getPriorTransactionIdentifier();
		ReportableExecutionVenue.ReportableExecutionVenueBuilder getOrCreateReportableExecutionVenue();
		@Override
		ReportableExecutionVenue.ReportableExecutionVenueBuilder getReportableExecutionVenue();
		TransactionInformation.TransactionInformationBuilder setTransactionIdentifier(TradeIdentifier transactionIdentifier);
		TransactionInformation.TransactionInformationBuilder setPriorTransactionIdentifier(TradeIdentifier priorTransactionIdentifier);
		TransactionInformation.TransactionInformationBuilder setReportableExecutionVenue(ReportableExecutionVenue reportableExecutionVenue);
		TransactionInformation.TransactionInformationBuilder setLargeSizeTrade(Boolean largeSizeTrade);
		TransactionInformation.TransactionInformationBuilder setDuration(CommodityTimeUnitEnum duration);
		TransactionInformation.TransactionInformationBuilder setTradableOnTradingVenue(TradableOnTradingVenueEnum tradableOnTradingVenue);
		TransactionInformation.TransactionInformationBuilder setUnderlierTradedOnTradingVenue(Boolean underlierTradedOnTradingVenue);
		TransactionInformation.TransactionInformationBuilder setUnderlierAssetTradingPlatformIdentifier(String underlierAssetTradingPlatformIdentifier);
		TransactionInformation.TransactionInformationBuilder setInternalTradeIdentifier(String internalTradeIdentifier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("transactionIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getTransactionIdentifier());
			processRosetta(path.newSubPath("priorTransactionIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getPriorTransactionIdentifier());
			processRosetta(path.newSubPath("reportableExecutionVenue"), processor, ReportableExecutionVenue.ReportableExecutionVenueBuilder.class, getReportableExecutionVenue());
			processor.processBasic(path.newSubPath("largeSizeTrade"), Boolean.class, getLargeSizeTrade(), this);
			processor.processBasic(path.newSubPath("duration"), CommodityTimeUnitEnum.class, getDuration(), this);
			processor.processBasic(path.newSubPath("tradableOnTradingVenue"), TradableOnTradingVenueEnum.class, getTradableOnTradingVenue(), this);
			processor.processBasic(path.newSubPath("underlierTradedOnTradingVenue"), Boolean.class, getUnderlierTradedOnTradingVenue(), this);
			processor.processBasic(path.newSubPath("underlierAssetTradingPlatformIdentifier"), String.class, getUnderlierAssetTradingPlatformIdentifier(), this);
			processor.processBasic(path.newSubPath("internalTradeIdentifier"), String.class, getInternalTradeIdentifier(), this);
		}
		

		TransactionInformation.TransactionInformationBuilder prune();
	}

	/*********************** Immutable Implementation of TransactionInformation  ***********************/
	class TransactionInformationImpl implements TransactionInformation {
		private final TradeIdentifier transactionIdentifier;
		private final TradeIdentifier priorTransactionIdentifier;
		private final ReportableExecutionVenue reportableExecutionVenue;
		private final Boolean largeSizeTrade;
		private final CommodityTimeUnitEnum duration;
		private final TradableOnTradingVenueEnum tradableOnTradingVenue;
		private final Boolean underlierTradedOnTradingVenue;
		private final String underlierAssetTradingPlatformIdentifier;
		private final String internalTradeIdentifier;
		
		protected TransactionInformationImpl(TransactionInformation.TransactionInformationBuilder builder) {
			this.transactionIdentifier = ofNullable(builder.getTransactionIdentifier()).map(f->f.build()).orElse(null);
			this.priorTransactionIdentifier = ofNullable(builder.getPriorTransactionIdentifier()).map(f->f.build()).orElse(null);
			this.reportableExecutionVenue = ofNullable(builder.getReportableExecutionVenue()).map(f->f.build()).orElse(null);
			this.largeSizeTrade = builder.getLargeSizeTrade();
			this.duration = builder.getDuration();
			this.tradableOnTradingVenue = builder.getTradableOnTradingVenue();
			this.underlierTradedOnTradingVenue = builder.getUnderlierTradedOnTradingVenue();
			this.underlierAssetTradingPlatformIdentifier = builder.getUnderlierAssetTradingPlatformIdentifier();
			this.internalTradeIdentifier = builder.getInternalTradeIdentifier();
		}
		
		@Override
		@RosettaAttribute("transactionIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transactionIdentifier")
		public TradeIdentifier getTransactionIdentifier() {
			return transactionIdentifier;
		}
		
		@Override
		@RosettaAttribute("priorTransactionIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priorTransactionIdentifier")
		public TradeIdentifier getPriorTransactionIdentifier() {
			return priorTransactionIdentifier;
		}
		
		@Override
		@RosettaAttribute("reportableExecutionVenue")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportableExecutionVenue")
		public ReportableExecutionVenue getReportableExecutionVenue() {
			return reportableExecutionVenue;
		}
		
		@Override
		@RosettaAttribute("largeSizeTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("largeSizeTrade")
		public Boolean getLargeSizeTrade() {
			return largeSizeTrade;
		}
		
		@Override
		@RosettaAttribute("duration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("duration")
		public CommodityTimeUnitEnum getDuration() {
			return duration;
		}
		
		@Override
		@RosettaAttribute("tradableOnTradingVenue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradableOnTradingVenue")
		public TradableOnTradingVenueEnum getTradableOnTradingVenue() {
			return tradableOnTradingVenue;
		}
		
		@Override
		@RosettaAttribute("underlierTradedOnTradingVenue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlierTradedOnTradingVenue")
		public Boolean getUnderlierTradedOnTradingVenue() {
			return underlierTradedOnTradingVenue;
		}
		
		@Override
		@RosettaAttribute("underlierAssetTradingPlatformIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlierAssetTradingPlatformIdentifier")
		public String getUnderlierAssetTradingPlatformIdentifier() {
			return underlierAssetTradingPlatformIdentifier;
		}
		
		@Override
		@RosettaAttribute("internalTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("internalTradeIdentifier")
		public String getInternalTradeIdentifier() {
			return internalTradeIdentifier;
		}
		
		@Override
		public TransactionInformation build() {
			return this;
		}
		
		@Override
		public TransactionInformation.TransactionInformationBuilder toBuilder() {
			TransactionInformation.TransactionInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TransactionInformation.TransactionInformationBuilder builder) {
			ofNullable(getTransactionIdentifier()).ifPresent(builder::setTransactionIdentifier);
			ofNullable(getPriorTransactionIdentifier()).ifPresent(builder::setPriorTransactionIdentifier);
			ofNullable(getReportableExecutionVenue()).ifPresent(builder::setReportableExecutionVenue);
			ofNullable(getLargeSizeTrade()).ifPresent(builder::setLargeSizeTrade);
			ofNullable(getDuration()).ifPresent(builder::setDuration);
			ofNullable(getTradableOnTradingVenue()).ifPresent(builder::setTradableOnTradingVenue);
			ofNullable(getUnderlierTradedOnTradingVenue()).ifPresent(builder::setUnderlierTradedOnTradingVenue);
			ofNullable(getUnderlierAssetTradingPlatformIdentifier()).ifPresent(builder::setUnderlierAssetTradingPlatformIdentifier);
			ofNullable(getInternalTradeIdentifier()).ifPresent(builder::setInternalTradeIdentifier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransactionInformation _that = getType().cast(o);
		
			if (!Objects.equals(transactionIdentifier, _that.getTransactionIdentifier())) return false;
			if (!Objects.equals(priorTransactionIdentifier, _that.getPriorTransactionIdentifier())) return false;
			if (!Objects.equals(reportableExecutionVenue, _that.getReportableExecutionVenue())) return false;
			if (!Objects.equals(largeSizeTrade, _that.getLargeSizeTrade())) return false;
			if (!Objects.equals(duration, _that.getDuration())) return false;
			if (!Objects.equals(tradableOnTradingVenue, _that.getTradableOnTradingVenue())) return false;
			if (!Objects.equals(underlierTradedOnTradingVenue, _that.getUnderlierTradedOnTradingVenue())) return false;
			if (!Objects.equals(underlierAssetTradingPlatformIdentifier, _that.getUnderlierAssetTradingPlatformIdentifier())) return false;
			if (!Objects.equals(internalTradeIdentifier, _that.getInternalTradeIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (transactionIdentifier != null ? transactionIdentifier.hashCode() : 0);
			_result = 31 * _result + (priorTransactionIdentifier != null ? priorTransactionIdentifier.hashCode() : 0);
			_result = 31 * _result + (reportableExecutionVenue != null ? reportableExecutionVenue.hashCode() : 0);
			_result = 31 * _result + (largeSizeTrade != null ? largeSizeTrade.hashCode() : 0);
			_result = 31 * _result + (duration != null ? duration.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tradableOnTradingVenue != null ? tradableOnTradingVenue.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlierTradedOnTradingVenue != null ? underlierTradedOnTradingVenue.hashCode() : 0);
			_result = 31 * _result + (underlierAssetTradingPlatformIdentifier != null ? underlierAssetTradingPlatformIdentifier.hashCode() : 0);
			_result = 31 * _result + (internalTradeIdentifier != null ? internalTradeIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransactionInformation {" +
				"transactionIdentifier=" + this.transactionIdentifier + ", " +
				"priorTransactionIdentifier=" + this.priorTransactionIdentifier + ", " +
				"reportableExecutionVenue=" + this.reportableExecutionVenue + ", " +
				"largeSizeTrade=" + this.largeSizeTrade + ", " +
				"duration=" + this.duration + ", " +
				"tradableOnTradingVenue=" + this.tradableOnTradingVenue + ", " +
				"underlierTradedOnTradingVenue=" + this.underlierTradedOnTradingVenue + ", " +
				"underlierAssetTradingPlatformIdentifier=" + this.underlierAssetTradingPlatformIdentifier + ", " +
				"internalTradeIdentifier=" + this.internalTradeIdentifier +
			'}';
		}
	}

	/*********************** Builder Implementation of TransactionInformation  ***********************/
	class TransactionInformationBuilderImpl implements TransactionInformation.TransactionInformationBuilder {
	
		protected TradeIdentifier.TradeIdentifierBuilder transactionIdentifier;
		protected TradeIdentifier.TradeIdentifierBuilder priorTransactionIdentifier;
		protected ReportableExecutionVenue.ReportableExecutionVenueBuilder reportableExecutionVenue;
		protected Boolean largeSizeTrade;
		protected CommodityTimeUnitEnum duration;
		protected TradableOnTradingVenueEnum tradableOnTradingVenue;
		protected Boolean underlierTradedOnTradingVenue;
		protected String underlierAssetTradingPlatformIdentifier;
		protected String internalTradeIdentifier;
		
		@Override
		@RosettaAttribute("transactionIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transactionIdentifier")
		public TradeIdentifier.TradeIdentifierBuilder getTransactionIdentifier() {
			return transactionIdentifier;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateTransactionIdentifier() {
			TradeIdentifier.TradeIdentifierBuilder result;
			if (transactionIdentifier!=null) {
				result = transactionIdentifier;
			}
			else {
				result = transactionIdentifier = TradeIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("priorTransactionIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priorTransactionIdentifier")
		public TradeIdentifier.TradeIdentifierBuilder getPriorTransactionIdentifier() {
			return priorTransactionIdentifier;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreatePriorTransactionIdentifier() {
			TradeIdentifier.TradeIdentifierBuilder result;
			if (priorTransactionIdentifier!=null) {
				result = priorTransactionIdentifier;
			}
			else {
				result = priorTransactionIdentifier = TradeIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reportableExecutionVenue")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportableExecutionVenue")
		public ReportableExecutionVenue.ReportableExecutionVenueBuilder getReportableExecutionVenue() {
			return reportableExecutionVenue;
		}
		
		@Override
		public ReportableExecutionVenue.ReportableExecutionVenueBuilder getOrCreateReportableExecutionVenue() {
			ReportableExecutionVenue.ReportableExecutionVenueBuilder result;
			if (reportableExecutionVenue!=null) {
				result = reportableExecutionVenue;
			}
			else {
				result = reportableExecutionVenue = ReportableExecutionVenue.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("largeSizeTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("largeSizeTrade")
		public Boolean getLargeSizeTrade() {
			return largeSizeTrade;
		}
		
		@Override
		@RosettaAttribute("duration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("duration")
		public CommodityTimeUnitEnum getDuration() {
			return duration;
		}
		
		@Override
		@RosettaAttribute("tradableOnTradingVenue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradableOnTradingVenue")
		public TradableOnTradingVenueEnum getTradableOnTradingVenue() {
			return tradableOnTradingVenue;
		}
		
		@Override
		@RosettaAttribute("underlierTradedOnTradingVenue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlierTradedOnTradingVenue")
		public Boolean getUnderlierTradedOnTradingVenue() {
			return underlierTradedOnTradingVenue;
		}
		
		@Override
		@RosettaAttribute("underlierAssetTradingPlatformIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlierAssetTradingPlatformIdentifier")
		public String getUnderlierAssetTradingPlatformIdentifier() {
			return underlierAssetTradingPlatformIdentifier;
		}
		
		@Override
		@RosettaAttribute("internalTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("internalTradeIdentifier")
		public String getInternalTradeIdentifier() {
			return internalTradeIdentifier;
		}
		
		@RosettaAttribute("transactionIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("transactionIdentifier")
		@Override
		public TransactionInformation.TransactionInformationBuilder setTransactionIdentifier(TradeIdentifier _transactionIdentifier) {
			this.transactionIdentifier = _transactionIdentifier == null ? null : _transactionIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("priorTransactionIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorTransactionIdentifier")
		@Override
		public TransactionInformation.TransactionInformationBuilder setPriorTransactionIdentifier(TradeIdentifier _priorTransactionIdentifier) {
			this.priorTransactionIdentifier = _priorTransactionIdentifier == null ? null : _priorTransactionIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportableExecutionVenue")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportableExecutionVenue")
		@Override
		public TransactionInformation.TransactionInformationBuilder setReportableExecutionVenue(ReportableExecutionVenue _reportableExecutionVenue) {
			this.reportableExecutionVenue = _reportableExecutionVenue == null ? null : _reportableExecutionVenue.toBuilder();
			return this;
		}
		
		@RosettaAttribute("largeSizeTrade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("largeSizeTrade")
		@Override
		public TransactionInformation.TransactionInformationBuilder setLargeSizeTrade(Boolean _largeSizeTrade) {
			this.largeSizeTrade = _largeSizeTrade == null ? null : _largeSizeTrade;
			return this;
		}
		
		@RosettaAttribute("duration")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("duration")
		@Override
		public TransactionInformation.TransactionInformationBuilder setDuration(CommodityTimeUnitEnum _duration) {
			this.duration = _duration == null ? null : _duration;
			return this;
		}
		
		@RosettaAttribute("tradableOnTradingVenue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradableOnTradingVenue")
		@Override
		public TransactionInformation.TransactionInformationBuilder setTradableOnTradingVenue(TradableOnTradingVenueEnum _tradableOnTradingVenue) {
			this.tradableOnTradingVenue = _tradableOnTradingVenue == null ? null : _tradableOnTradingVenue;
			return this;
		}
		
		@RosettaAttribute("underlierTradedOnTradingVenue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlierTradedOnTradingVenue")
		@Override
		public TransactionInformation.TransactionInformationBuilder setUnderlierTradedOnTradingVenue(Boolean _underlierTradedOnTradingVenue) {
			this.underlierTradedOnTradingVenue = _underlierTradedOnTradingVenue == null ? null : _underlierTradedOnTradingVenue;
			return this;
		}
		
		@RosettaAttribute("underlierAssetTradingPlatformIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlierAssetTradingPlatformIdentifier")
		@Override
		public TransactionInformation.TransactionInformationBuilder setUnderlierAssetTradingPlatformIdentifier(String _underlierAssetTradingPlatformIdentifier) {
			this.underlierAssetTradingPlatformIdentifier = _underlierAssetTradingPlatformIdentifier == null ? null : _underlierAssetTradingPlatformIdentifier;
			return this;
		}
		
		@RosettaAttribute("internalTradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("internalTradeIdentifier")
		@Override
		public TransactionInformation.TransactionInformationBuilder setInternalTradeIdentifier(String _internalTradeIdentifier) {
			this.internalTradeIdentifier = _internalTradeIdentifier == null ? null : _internalTradeIdentifier;
			return this;
		}
		
		@Override
		public TransactionInformation build() {
			return new TransactionInformation.TransactionInformationImpl(this);
		}
		
		@Override
		public TransactionInformation.TransactionInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransactionInformation.TransactionInformationBuilder prune() {
			if (transactionIdentifier!=null && !transactionIdentifier.prune().hasData()) transactionIdentifier = null;
			if (priorTransactionIdentifier!=null && !priorTransactionIdentifier.prune().hasData()) priorTransactionIdentifier = null;
			if (reportableExecutionVenue!=null && !reportableExecutionVenue.prune().hasData()) reportableExecutionVenue = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTransactionIdentifier()!=null && getTransactionIdentifier().hasData()) return true;
			if (getPriorTransactionIdentifier()!=null && getPriorTransactionIdentifier().hasData()) return true;
			if (getReportableExecutionVenue()!=null && getReportableExecutionVenue().hasData()) return true;
			if (getLargeSizeTrade()!=null) return true;
			if (getDuration()!=null) return true;
			if (getTradableOnTradingVenue()!=null) return true;
			if (getUnderlierTradedOnTradingVenue()!=null) return true;
			if (getUnderlierAssetTradingPlatformIdentifier()!=null) return true;
			if (getInternalTradeIdentifier()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransactionInformation.TransactionInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TransactionInformation.TransactionInformationBuilder o = (TransactionInformation.TransactionInformationBuilder) other;
			
			merger.mergeRosetta(getTransactionIdentifier(), o.getTransactionIdentifier(), this::setTransactionIdentifier);
			merger.mergeRosetta(getPriorTransactionIdentifier(), o.getPriorTransactionIdentifier(), this::setPriorTransactionIdentifier);
			merger.mergeRosetta(getReportableExecutionVenue(), o.getReportableExecutionVenue(), this::setReportableExecutionVenue);
			
			merger.mergeBasic(getLargeSizeTrade(), o.getLargeSizeTrade(), this::setLargeSizeTrade);
			merger.mergeBasic(getDuration(), o.getDuration(), this::setDuration);
			merger.mergeBasic(getTradableOnTradingVenue(), o.getTradableOnTradingVenue(), this::setTradableOnTradingVenue);
			merger.mergeBasic(getUnderlierTradedOnTradingVenue(), o.getUnderlierTradedOnTradingVenue(), this::setUnderlierTradedOnTradingVenue);
			merger.mergeBasic(getUnderlierAssetTradingPlatformIdentifier(), o.getUnderlierAssetTradingPlatformIdentifier(), this::setUnderlierAssetTradingPlatformIdentifier);
			merger.mergeBasic(getInternalTradeIdentifier(), o.getInternalTradeIdentifier(), this::setInternalTradeIdentifier);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransactionInformation _that = getType().cast(o);
		
			if (!Objects.equals(transactionIdentifier, _that.getTransactionIdentifier())) return false;
			if (!Objects.equals(priorTransactionIdentifier, _that.getPriorTransactionIdentifier())) return false;
			if (!Objects.equals(reportableExecutionVenue, _that.getReportableExecutionVenue())) return false;
			if (!Objects.equals(largeSizeTrade, _that.getLargeSizeTrade())) return false;
			if (!Objects.equals(duration, _that.getDuration())) return false;
			if (!Objects.equals(tradableOnTradingVenue, _that.getTradableOnTradingVenue())) return false;
			if (!Objects.equals(underlierTradedOnTradingVenue, _that.getUnderlierTradedOnTradingVenue())) return false;
			if (!Objects.equals(underlierAssetTradingPlatformIdentifier, _that.getUnderlierAssetTradingPlatformIdentifier())) return false;
			if (!Objects.equals(internalTradeIdentifier, _that.getInternalTradeIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (transactionIdentifier != null ? transactionIdentifier.hashCode() : 0);
			_result = 31 * _result + (priorTransactionIdentifier != null ? priorTransactionIdentifier.hashCode() : 0);
			_result = 31 * _result + (reportableExecutionVenue != null ? reportableExecutionVenue.hashCode() : 0);
			_result = 31 * _result + (largeSizeTrade != null ? largeSizeTrade.hashCode() : 0);
			_result = 31 * _result + (duration != null ? duration.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tradableOnTradingVenue != null ? tradableOnTradingVenue.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlierTradedOnTradingVenue != null ? underlierTradedOnTradingVenue.hashCode() : 0);
			_result = 31 * _result + (underlierAssetTradingPlatformIdentifier != null ? underlierAssetTradingPlatformIdentifier.hashCode() : 0);
			_result = 31 * _result + (internalTradeIdentifier != null ? internalTradeIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransactionInformationBuilder {" +
				"transactionIdentifier=" + this.transactionIdentifier + ", " +
				"priorTransactionIdentifier=" + this.priorTransactionIdentifier + ", " +
				"reportableExecutionVenue=" + this.reportableExecutionVenue + ", " +
				"largeSizeTrade=" + this.largeSizeTrade + ", " +
				"duration=" + this.duration + ", " +
				"tradableOnTradingVenue=" + this.tradableOnTradingVenue + ", " +
				"underlierTradedOnTradingVenue=" + this.underlierTradedOnTradingVenue + ", " +
				"underlierAssetTradingPlatformIdentifier=" + this.underlierAssetTradingPlatformIdentifier + ", " +
				"internalTradeIdentifier=" + this.internalTradeIdentifier +
			'}';
		}
	}
}

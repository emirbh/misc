package fpml.consolidated.eq.shared;

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
import fpml.consolidated.eq.shared.meta.CorrelationMeta;
import fpml.consolidated.shared.DeterminationMethod;
import fpml.consolidated.shared.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type describing the correlation amount of a correlation swap.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing the correlation amount of a correlation swap.
 *
 */
@RosettaDataType(value="Correlation", builder=Correlation.CorrelationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Correlation", model="fpml", builder=Correlation.CorrelationBuilderImpl.class, version="2.1.1")
public interface Correlation extends CalculationFromObservation {

	CorrelationMeta metaData = new CorrelationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Notional amount, which is a cash multiplier.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Notional amount, which is a cash multiplier.
	 *
	 */
	NonNegativeMoney getNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Correlation Strike Price.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Correlation Strike Price.
	 *
	 */
	BigDecimal getCorrelationStrikePrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Bounded Correlation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Bounded Correlation.
	 *
	 */
	BoundedCorrelation getBoundedCorrelation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Number of data series, normal market practice is that correlation data sets are drawn from geographic market areas, such as America, Europe and Asia Pacific, each of these geographic areas will have its own data series to avoid contagion.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Number of data series, normal market practice is that correlation data sets are drawn from geographic market areas, such as America, Europe and Asia Pacific, each of these geographic areas will have its own data series to avoid contagion.
	 *
	 */
	Integer getNumberOfDataSeries();

	/*********************** Build Methods  ***********************/
	Correlation build();
	
	Correlation.CorrelationBuilder toBuilder();
	
	static Correlation.CorrelationBuilder builder() {
		return new Correlation.CorrelationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Correlation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Correlation> getType() {
		return Correlation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("initialLevel"), BigDecimal.class, getInitialLevel(), this);
		processRosetta(path.newSubPath("initialLevelSource"), processor, DeterminationMethod.class, getInitialLevelSource());
		processor.processBasic(path.newSubPath("closingLevel"), Boolean.class, getClosingLevel(), this);
		processor.processBasic(path.newSubPath("expiringLevel"), Boolean.class, getExpiringLevel(), this);
		processor.processBasic(path.newSubPath("expectedN"), Integer.class, getExpectedN(), this);
		processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeMoney.class, getNotionalAmount());
		processor.processBasic(path.newSubPath("correlationStrikePrice"), BigDecimal.class, getCorrelationStrikePrice(), this);
		processRosetta(path.newSubPath("boundedCorrelation"), processor, BoundedCorrelation.class, getBoundedCorrelation());
		processor.processBasic(path.newSubPath("numberOfDataSeries"), Integer.class, getNumberOfDataSeries(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CorrelationBuilder extends Correlation, CalculationFromObservation.CalculationFromObservationBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateNotionalAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getNotionalAmount();
		BoundedCorrelation.BoundedCorrelationBuilder getOrCreateBoundedCorrelation();
		@Override
		BoundedCorrelation.BoundedCorrelationBuilder getBoundedCorrelation();
		@Override
		Correlation.CorrelationBuilder setInitialLevel(BigDecimal initialLevel);
		@Override
		Correlation.CorrelationBuilder setInitialLevelSource(DeterminationMethod initialLevelSource);
		@Override
		Correlation.CorrelationBuilder setClosingLevel(Boolean closingLevel);
		@Override
		Correlation.CorrelationBuilder setExpiringLevel(Boolean expiringLevel);
		@Override
		Correlation.CorrelationBuilder setExpectedN(Integer expectedN);
		Correlation.CorrelationBuilder setNotionalAmount(NonNegativeMoney notionalAmount);
		Correlation.CorrelationBuilder setCorrelationStrikePrice(BigDecimal correlationStrikePrice);
		Correlation.CorrelationBuilder setBoundedCorrelation(BoundedCorrelation boundedCorrelation);
		Correlation.CorrelationBuilder setNumberOfDataSeries(Integer numberOfDataSeries);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("initialLevel"), BigDecimal.class, getInitialLevel(), this);
			processRosetta(path.newSubPath("initialLevelSource"), processor, DeterminationMethod.DeterminationMethodBuilder.class, getInitialLevelSource());
			processor.processBasic(path.newSubPath("closingLevel"), Boolean.class, getClosingLevel(), this);
			processor.processBasic(path.newSubPath("expiringLevel"), Boolean.class, getExpiringLevel(), this);
			processor.processBasic(path.newSubPath("expectedN"), Integer.class, getExpectedN(), this);
			processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getNotionalAmount());
			processor.processBasic(path.newSubPath("correlationStrikePrice"), BigDecimal.class, getCorrelationStrikePrice(), this);
			processRosetta(path.newSubPath("boundedCorrelation"), processor, BoundedCorrelation.BoundedCorrelationBuilder.class, getBoundedCorrelation());
			processor.processBasic(path.newSubPath("numberOfDataSeries"), Integer.class, getNumberOfDataSeries(), this);
		}
		

		Correlation.CorrelationBuilder prune();
	}

	/*********************** Immutable Implementation of Correlation  ***********************/
	class CorrelationImpl extends CalculationFromObservation.CalculationFromObservationImpl implements Correlation {
		private final NonNegativeMoney notionalAmount;
		private final BigDecimal correlationStrikePrice;
		private final BoundedCorrelation boundedCorrelation;
		private final Integer numberOfDataSeries;
		
		protected CorrelationImpl(Correlation.CorrelationBuilder builder) {
			super(builder);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.correlationStrikePrice = builder.getCorrelationStrikePrice();
			this.boundedCorrelation = ofNullable(builder.getBoundedCorrelation()).map(f->f.build()).orElse(null);
			this.numberOfDataSeries = builder.getNumberOfDataSeries();
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("notionalAmount")
		public NonNegativeMoney getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("correlationStrikePrice")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("correlationStrikePrice")
		public BigDecimal getCorrelationStrikePrice() {
			return correlationStrikePrice;
		}
		
		@Override
		@RosettaAttribute("boundedCorrelation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("boundedCorrelation")
		public BoundedCorrelation getBoundedCorrelation() {
			return boundedCorrelation;
		}
		
		@Override
		@RosettaAttribute("numberOfDataSeries")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfDataSeries")
		public Integer getNumberOfDataSeries() {
			return numberOfDataSeries;
		}
		
		@Override
		public Correlation build() {
			return this;
		}
		
		@Override
		public Correlation.CorrelationBuilder toBuilder() {
			Correlation.CorrelationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Correlation.CorrelationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getCorrelationStrikePrice()).ifPresent(builder::setCorrelationStrikePrice);
			ofNullable(getBoundedCorrelation()).ifPresent(builder::setBoundedCorrelation);
			ofNullable(getNumberOfDataSeries()).ifPresent(builder::setNumberOfDataSeries);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Correlation _that = getType().cast(o);
		
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(correlationStrikePrice, _that.getCorrelationStrikePrice())) return false;
			if (!Objects.equals(boundedCorrelation, _that.getBoundedCorrelation())) return false;
			if (!Objects.equals(numberOfDataSeries, _that.getNumberOfDataSeries())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (correlationStrikePrice != null ? correlationStrikePrice.hashCode() : 0);
			_result = 31 * _result + (boundedCorrelation != null ? boundedCorrelation.hashCode() : 0);
			_result = 31 * _result + (numberOfDataSeries != null ? numberOfDataSeries.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Correlation {" +
				"notionalAmount=" + this.notionalAmount + ", " +
				"correlationStrikePrice=" + this.correlationStrikePrice + ", " +
				"boundedCorrelation=" + this.boundedCorrelation + ", " +
				"numberOfDataSeries=" + this.numberOfDataSeries +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Correlation  ***********************/
	class CorrelationBuilderImpl extends CalculationFromObservation.CalculationFromObservationBuilderImpl implements Correlation.CorrelationBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder notionalAmount;
		protected BigDecimal correlationStrikePrice;
		protected BoundedCorrelation.BoundedCorrelationBuilder boundedCorrelation;
		protected Integer numberOfDataSeries;
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("notionalAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateNotionalAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (notionalAmount!=null) {
				result = notionalAmount;
			}
			else {
				result = notionalAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("correlationStrikePrice")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("correlationStrikePrice")
		public BigDecimal getCorrelationStrikePrice() {
			return correlationStrikePrice;
		}
		
		@Override
		@RosettaAttribute("boundedCorrelation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("boundedCorrelation")
		public BoundedCorrelation.BoundedCorrelationBuilder getBoundedCorrelation() {
			return boundedCorrelation;
		}
		
		@Override
		public BoundedCorrelation.BoundedCorrelationBuilder getOrCreateBoundedCorrelation() {
			BoundedCorrelation.BoundedCorrelationBuilder result;
			if (boundedCorrelation!=null) {
				result = boundedCorrelation;
			}
			else {
				result = boundedCorrelation = BoundedCorrelation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("numberOfDataSeries")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfDataSeries")
		public Integer getNumberOfDataSeries() {
			return numberOfDataSeries;
		}
		
		@RosettaAttribute("initialLevel")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialLevel")
		@Override
		public Correlation.CorrelationBuilder setInitialLevel(BigDecimal _initialLevel) {
			this.initialLevel = _initialLevel == null ? null : _initialLevel;
			return this;
		}
		
		@RosettaAttribute("initialLevelSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialLevelSource")
		@Override
		public Correlation.CorrelationBuilder setInitialLevelSource(DeterminationMethod _initialLevelSource) {
			this.initialLevelSource = _initialLevelSource == null ? null : _initialLevelSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("closingLevel")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("closingLevel")
		@Override
		public Correlation.CorrelationBuilder setClosingLevel(Boolean _closingLevel) {
			this.closingLevel = _closingLevel == null ? null : _closingLevel;
			return this;
		}
		
		@RosettaAttribute("expiringLevel")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiringLevel")
		@Override
		public Correlation.CorrelationBuilder setExpiringLevel(Boolean _expiringLevel) {
			this.expiringLevel = _expiringLevel == null ? null : _expiringLevel;
			return this;
		}
		
		@RosettaAttribute("expectedN")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedN")
		@Override
		public Correlation.CorrelationBuilder setExpectedN(Integer _expectedN) {
			this.expectedN = _expectedN == null ? null : _expectedN;
			return this;
		}
		
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("notionalAmount")
		@Override
		public Correlation.CorrelationBuilder setNotionalAmount(NonNegativeMoney _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationStrikePrice")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("correlationStrikePrice")
		@Override
		public Correlation.CorrelationBuilder setCorrelationStrikePrice(BigDecimal _correlationStrikePrice) {
			this.correlationStrikePrice = _correlationStrikePrice == null ? null : _correlationStrikePrice;
			return this;
		}
		
		@RosettaAttribute("boundedCorrelation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("boundedCorrelation")
		@Override
		public Correlation.CorrelationBuilder setBoundedCorrelation(BoundedCorrelation _boundedCorrelation) {
			this.boundedCorrelation = _boundedCorrelation == null ? null : _boundedCorrelation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("numberOfDataSeries")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("numberOfDataSeries")
		@Override
		public Correlation.CorrelationBuilder setNumberOfDataSeries(Integer _numberOfDataSeries) {
			this.numberOfDataSeries = _numberOfDataSeries == null ? null : _numberOfDataSeries;
			return this;
		}
		
		@Override
		public Correlation build() {
			return new Correlation.CorrelationImpl(this);
		}
		
		@Override
		public Correlation.CorrelationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Correlation.CorrelationBuilder prune() {
			super.prune();
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			if (boundedCorrelation!=null && !boundedCorrelation.prune().hasData()) boundedCorrelation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getCorrelationStrikePrice()!=null) return true;
			if (getBoundedCorrelation()!=null && getBoundedCorrelation().hasData()) return true;
			if (getNumberOfDataSeries()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Correlation.CorrelationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Correlation.CorrelationBuilder o = (Correlation.CorrelationBuilder) other;
			
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getBoundedCorrelation(), o.getBoundedCorrelation(), this::setBoundedCorrelation);
			
			merger.mergeBasic(getCorrelationStrikePrice(), o.getCorrelationStrikePrice(), this::setCorrelationStrikePrice);
			merger.mergeBasic(getNumberOfDataSeries(), o.getNumberOfDataSeries(), this::setNumberOfDataSeries);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Correlation _that = getType().cast(o);
		
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(correlationStrikePrice, _that.getCorrelationStrikePrice())) return false;
			if (!Objects.equals(boundedCorrelation, _that.getBoundedCorrelation())) return false;
			if (!Objects.equals(numberOfDataSeries, _that.getNumberOfDataSeries())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (correlationStrikePrice != null ? correlationStrikePrice.hashCode() : 0);
			_result = 31 * _result + (boundedCorrelation != null ? boundedCorrelation.hashCode() : 0);
			_result = 31 * _result + (numberOfDataSeries != null ? numberOfDataSeries.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrelationBuilder {" +
				"notionalAmount=" + this.notionalAmount + ", " +
				"correlationStrikePrice=" + this.correlationStrikePrice + ", " +
				"boundedCorrelation=" + this.boundedCorrelation + ", " +
				"numberOfDataSeries=" + this.numberOfDataSeries +
			'}' + " " + super.toString();
		}
	}
}

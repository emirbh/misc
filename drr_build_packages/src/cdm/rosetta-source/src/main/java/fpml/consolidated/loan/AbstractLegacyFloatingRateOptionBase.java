package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.AbstractLegacyFloatingRateOptionBaseMeta;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.Period;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An abstract type that specifies an underlying floating rate cash accrual option.
 *
 */
@RosettaDataType(value="AbstractLegacyFloatingRateOptionBase", builder=AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractLegacyFloatingRateOptionBase", model="fpml", builder=AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilderImpl.class, version="2.1.1")
public interface AbstractLegacyFloatingRateOptionBase extends AbstractLegacyAccrualOptionBase {

	AbstractLegacyFloatingRateOptionBaseMeta metaData = new AbstractLegacyFloatingRateOptionBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	LegacyFloatingRateIndexLoan getLegacyFloatingRateIndex();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The ISDA Designated Maturity, i.e. the tenor of the floating rate.
	 *
	 */
	Period getIndexTenor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	BigDecimal getSpread();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	BigDecimal getPikSpread();

	/*********************** Build Methods  ***********************/
	AbstractLegacyFloatingRateOptionBase build();
	
	AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder toBuilder();
	
	static AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder builder() {
		return new AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLegacyFloatingRateOptionBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractLegacyFloatingRateOptionBase> getType() {
		return AbstractLegacyFloatingRateOptionBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.class, getAccrualOptionId());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processRosetta(path.newSubPath("legacyFloatingRateIndex"), processor, LegacyFloatingRateIndexLoan.class, getLegacyFloatingRateIndex());
		processRosetta(path.newSubPath("indexTenor"), processor, Period.class, getIndexTenor());
		processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
		processor.processBasic(path.newSubPath("pikSpread"), BigDecimal.class, getPikSpread(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLegacyFloatingRateOptionBaseBuilder extends AbstractLegacyFloatingRateOptionBase, AbstractLegacyAccrualOptionBase.AbstractLegacyAccrualOptionBaseBuilder {
		LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilder getOrCreateLegacyFloatingRateIndex();
		@Override
		LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilder getLegacyFloatingRateIndex();
		Period.PeriodBuilder getOrCreateIndexTenor();
		@Override
		Period.PeriodBuilder getIndexTenor();
		@Override
		AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder setAccrualOptionId(AccrualTypeId accrualOptionId);
		@Override
		AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		@Override
		AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder setPaymentFrequency(Period paymentFrequency);
		AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder setLegacyFloatingRateIndex(LegacyFloatingRateIndexLoan legacyFloatingRateIndex);
		AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder setIndexTenor(Period indexTenor);
		AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder setSpread(BigDecimal spread);
		AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder setPikSpread(BigDecimal pikSpread);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccrualOptionId());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processRosetta(path.newSubPath("legacyFloatingRateIndex"), processor, LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilder.class, getLegacyFloatingRateIndex());
			processRosetta(path.newSubPath("indexTenor"), processor, Period.PeriodBuilder.class, getIndexTenor());
			processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
			processor.processBasic(path.newSubPath("pikSpread"), BigDecimal.class, getPikSpread(), this);
		}
		

		AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLegacyFloatingRateOptionBase  ***********************/
	class AbstractLegacyFloatingRateOptionBaseImpl extends AbstractLegacyAccrualOptionBase.AbstractLegacyAccrualOptionBaseImpl implements AbstractLegacyFloatingRateOptionBase {
		private final LegacyFloatingRateIndexLoan legacyFloatingRateIndex;
		private final Period indexTenor;
		private final BigDecimal spread;
		private final BigDecimal pikSpread;
		
		protected AbstractLegacyFloatingRateOptionBaseImpl(AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder builder) {
			super(builder);
			this.legacyFloatingRateIndex = ofNullable(builder.getLegacyFloatingRateIndex()).map(f->f.build()).orElse(null);
			this.indexTenor = ofNullable(builder.getIndexTenor()).map(f->f.build()).orElse(null);
			this.spread = builder.getSpread();
			this.pikSpread = builder.getPikSpread();
		}
		
		@Override
		@RosettaAttribute("legacyFloatingRateIndex")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("legacyFloatingRateIndex")
		public LegacyFloatingRateIndexLoan getLegacyFloatingRateIndex() {
			return legacyFloatingRateIndex;
		}
		
		@Override
		@RosettaAttribute("indexTenor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexTenor")
		public Period getIndexTenor() {
			return indexTenor;
		}
		
		@Override
		@RosettaAttribute("spread")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("spread")
		public BigDecimal getSpread() {
			return spread;
		}
		
		@Override
		@RosettaAttribute("pikSpread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pikSpread")
		public BigDecimal getPikSpread() {
			return pikSpread;
		}
		
		@Override
		public AbstractLegacyFloatingRateOptionBase build() {
			return this;
		}
		
		@Override
		public AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder toBuilder() {
			AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLegacyFloatingRateIndex()).ifPresent(builder::setLegacyFloatingRateIndex);
			ofNullable(getIndexTenor()).ifPresent(builder::setIndexTenor);
			ofNullable(getSpread()).ifPresent(builder::setSpread);
			ofNullable(getPikSpread()).ifPresent(builder::setPikSpread);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLegacyFloatingRateOptionBase _that = getType().cast(o);
		
			if (!Objects.equals(legacyFloatingRateIndex, _that.getLegacyFloatingRateIndex())) return false;
			if (!Objects.equals(indexTenor, _that.getIndexTenor())) return false;
			if (!Objects.equals(spread, _that.getSpread())) return false;
			if (!Objects.equals(pikSpread, _that.getPikSpread())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (legacyFloatingRateIndex != null ? legacyFloatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			_result = 31 * _result + (pikSpread != null ? pikSpread.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLegacyFloatingRateOptionBase {" +
				"legacyFloatingRateIndex=" + this.legacyFloatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor + ", " +
				"spread=" + this.spread + ", " +
				"pikSpread=" + this.pikSpread +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractLegacyFloatingRateOptionBase  ***********************/
	class AbstractLegacyFloatingRateOptionBaseBuilderImpl extends AbstractLegacyAccrualOptionBase.AbstractLegacyAccrualOptionBaseBuilderImpl implements AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder {
	
		protected LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilder legacyFloatingRateIndex;
		protected Period.PeriodBuilder indexTenor;
		protected BigDecimal spread;
		protected BigDecimal pikSpread;
		
		@Override
		@RosettaAttribute("legacyFloatingRateIndex")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("legacyFloatingRateIndex")
		public LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilder getLegacyFloatingRateIndex() {
			return legacyFloatingRateIndex;
		}
		
		@Override
		public LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilder getOrCreateLegacyFloatingRateIndex() {
			LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilder result;
			if (legacyFloatingRateIndex!=null) {
				result = legacyFloatingRateIndex;
			}
			else {
				result = legacyFloatingRateIndex = LegacyFloatingRateIndexLoan.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexTenor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexTenor")
		public Period.PeriodBuilder getIndexTenor() {
			return indexTenor;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateIndexTenor() {
			Period.PeriodBuilder result;
			if (indexTenor!=null) {
				result = indexTenor;
			}
			else {
				result = indexTenor = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spread")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("spread")
		public BigDecimal getSpread() {
			return spread;
		}
		
		@Override
		@RosettaAttribute("pikSpread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pikSpread")
		public BigDecimal getPikSpread() {
			return pikSpread;
		}
		
		@RosettaAttribute("accrualOptionId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("accrualOptionId")
		@Override
		public AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder setAccrualOptionId(AccrualTypeId _accrualOptionId) {
			this.accrualOptionId = _accrualOptionId == null ? null : _accrualOptionId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dayCountFraction")
		@Override
		public AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentFrequency")
		@Override
		public AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder setPaymentFrequency(Period _paymentFrequency) {
			this.paymentFrequency = _paymentFrequency == null ? null : _paymentFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("legacyFloatingRateIndex")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("legacyFloatingRateIndex")
		@Override
		public AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder setLegacyFloatingRateIndex(LegacyFloatingRateIndexLoan _legacyFloatingRateIndex) {
			this.legacyFloatingRateIndex = _legacyFloatingRateIndex == null ? null : _legacyFloatingRateIndex.toBuilder();
			return this;
		}
		
		@RosettaAttribute("indexTenor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexTenor")
		@Override
		public AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder setIndexTenor(Period _indexTenor) {
			this.indexTenor = _indexTenor == null ? null : _indexTenor.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spread")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("spread")
		@Override
		public AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder setSpread(BigDecimal _spread) {
			this.spread = _spread == null ? null : _spread;
			return this;
		}
		
		@RosettaAttribute("pikSpread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pikSpread")
		@Override
		public AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder setPikSpread(BigDecimal _pikSpread) {
			this.pikSpread = _pikSpread == null ? null : _pikSpread;
			return this;
		}
		
		@Override
		public AbstractLegacyFloatingRateOptionBase build() {
			return new AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseImpl(this);
		}
		
		@Override
		public AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder prune() {
			super.prune();
			if (legacyFloatingRateIndex!=null && !legacyFloatingRateIndex.prune().hasData()) legacyFloatingRateIndex = null;
			if (indexTenor!=null && !indexTenor.prune().hasData()) indexTenor = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLegacyFloatingRateIndex()!=null && getLegacyFloatingRateIndex().hasData()) return true;
			if (getIndexTenor()!=null && getIndexTenor().hasData()) return true;
			if (getSpread()!=null) return true;
			if (getPikSpread()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder o = (AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder) other;
			
			merger.mergeRosetta(getLegacyFloatingRateIndex(), o.getLegacyFloatingRateIndex(), this::setLegacyFloatingRateIndex);
			merger.mergeRosetta(getIndexTenor(), o.getIndexTenor(), this::setIndexTenor);
			
			merger.mergeBasic(getSpread(), o.getSpread(), this::setSpread);
			merger.mergeBasic(getPikSpread(), o.getPikSpread(), this::setPikSpread);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLegacyFloatingRateOptionBase _that = getType().cast(o);
		
			if (!Objects.equals(legacyFloatingRateIndex, _that.getLegacyFloatingRateIndex())) return false;
			if (!Objects.equals(indexTenor, _that.getIndexTenor())) return false;
			if (!Objects.equals(spread, _that.getSpread())) return false;
			if (!Objects.equals(pikSpread, _that.getPikSpread())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (legacyFloatingRateIndex != null ? legacyFloatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			_result = 31 * _result + (pikSpread != null ? pikSpread.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLegacyFloatingRateOptionBaseBuilder {" +
				"legacyFloatingRateIndex=" + this.legacyFloatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor + ", " +
				"spread=" + this.spread + ", " +
				"pikSpread=" + this.pikSpread +
			'}' + " " + super.toString();
		}
	}
}

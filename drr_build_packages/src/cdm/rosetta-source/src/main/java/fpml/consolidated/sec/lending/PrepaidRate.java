package fpml.consolidated.sec.lending;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.sec.lending.meta.PrepaidRateMeta;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.Period;
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
 * Provision Specifies the rate which is applied to cash collateral when the cash collateral is settled ahead of the borrowed security. For example: at the initiation of the transaction, the borrow may post some cash right away, which gets returned overnight and substituted with securities, which would constitute as a collateral going forward. On T-0, you might actually hold some cash, pending the delivery of securities.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Specifies the rate which is applied to cash collateral when the cash collateral is settled ahead of the borrowed security. For example: at the initiation of the transaction, the borrow may post some cash right away, which gets returned overnight and substituted with securities, which would constitute as a collateral going forward. On T-0, you might actually hold some cash, pending the delivery of securities.
 *
 */
@RosettaDataType(value="PrepaidRate", builder=PrepaidRate.PrepaidRateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PrepaidRate", model="fpml", builder=PrepaidRate.PrepaidRateBuilderImpl.class, version="2.1.1")
public interface PrepaidRate extends RosettaModelObject {

	PrepaidRateMeta metaData = new PrepaidRateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the fixed rate which is applied to cash collateral when the cash collateral is settled ahead of the borrowed security.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the fixed rate which is applied to cash collateral when the cash collateral is settled ahead of the borrowed security.
	 *
	 */
	BigDecimal getFixedRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The ISDA Floating Rate Option, i.e. the name of the floating rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The ISDA Floating Rate Option, i.e. the name of the floating rate.
	 *
	 */
	FloatingRateIndex getFloatingRateIndex();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The ISDA Designated Maturity, i.e. the tenor of the floating rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The ISDA Designated Maturity, i.e. the tenor of the floating rate.
	 *
	 */
	Period getIndexTenor();

	/*********************** Build Methods  ***********************/
	PrepaidRate build();
	
	PrepaidRate.PrepaidRateBuilder toBuilder();
	
	static PrepaidRate.PrepaidRateBuilder builder() {
		return new PrepaidRate.PrepaidRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PrepaidRate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PrepaidRate> getType() {
		return PrepaidRate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
		processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndex.class, getFloatingRateIndex());
		processRosetta(path.newSubPath("indexTenor"), processor, Period.class, getIndexTenor());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PrepaidRateBuilder extends PrepaidRate, RosettaModelObjectBuilder {
		FloatingRateIndex.FloatingRateIndexBuilder getOrCreateFloatingRateIndex();
		@Override
		FloatingRateIndex.FloatingRateIndexBuilder getFloatingRateIndex();
		Period.PeriodBuilder getOrCreateIndexTenor();
		@Override
		Period.PeriodBuilder getIndexTenor();
		PrepaidRate.PrepaidRateBuilder setFixedRate(BigDecimal fixedRate);
		PrepaidRate.PrepaidRateBuilder setFloatingRateIndex(FloatingRateIndex floatingRateIndex);
		PrepaidRate.PrepaidRateBuilder setIndexTenor(Period indexTenor);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
			processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndex.FloatingRateIndexBuilder.class, getFloatingRateIndex());
			processRosetta(path.newSubPath("indexTenor"), processor, Period.PeriodBuilder.class, getIndexTenor());
		}
		

		PrepaidRate.PrepaidRateBuilder prune();
	}

	/*********************** Immutable Implementation of PrepaidRate  ***********************/
	class PrepaidRateImpl implements PrepaidRate {
		private final BigDecimal fixedRate;
		private final FloatingRateIndex floatingRateIndex;
		private final Period indexTenor;
		
		protected PrepaidRateImpl(PrepaidRate.PrepaidRateBuilder builder) {
			this.fixedRate = builder.getFixedRate();
			this.floatingRateIndex = ofNullable(builder.getFloatingRateIndex()).map(f->f.build()).orElse(null);
			this.indexTenor = ofNullable(builder.getIndexTenor()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRate")
		public BigDecimal getFixedRate() {
			return fixedRate;
		}
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateIndex")
		public FloatingRateIndex getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		@RosettaAttribute("indexTenor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexTenor")
		public Period getIndexTenor() {
			return indexTenor;
		}
		
		@Override
		public PrepaidRate build() {
			return this;
		}
		
		@Override
		public PrepaidRate.PrepaidRateBuilder toBuilder() {
			PrepaidRate.PrepaidRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PrepaidRate.PrepaidRateBuilder builder) {
			ofNullable(getFixedRate()).ifPresent(builder::setFixedRate);
			ofNullable(getFloatingRateIndex()).ifPresent(builder::setFloatingRateIndex);
			ofNullable(getIndexTenor()).ifPresent(builder::setIndexTenor);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrepaidRate _that = getType().cast(o);
		
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(indexTenor, _that.getIndexTenor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrepaidRate {" +
				"fixedRate=" + this.fixedRate + ", " +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor +
			'}';
		}
	}

	/*********************** Builder Implementation of PrepaidRate  ***********************/
	class PrepaidRateBuilderImpl implements PrepaidRate.PrepaidRateBuilder {
	
		protected BigDecimal fixedRate;
		protected FloatingRateIndex.FloatingRateIndexBuilder floatingRateIndex;
		protected Period.PeriodBuilder indexTenor;
		
		@Override
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRate")
		public BigDecimal getFixedRate() {
			return fixedRate;
		}
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateIndex")
		public FloatingRateIndex.FloatingRateIndexBuilder getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder getOrCreateFloatingRateIndex() {
			FloatingRateIndex.FloatingRateIndexBuilder result;
			if (floatingRateIndex!=null) {
				result = floatingRateIndex;
			}
			else {
				result = floatingRateIndex = FloatingRateIndex.builder();
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
		
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRate")
		@Override
		public PrepaidRate.PrepaidRateBuilder setFixedRate(BigDecimal _fixedRate) {
			this.fixedRate = _fixedRate == null ? null : _fixedRate;
			return this;
		}
		
		@RosettaAttribute("floatingRateIndex")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateIndex")
		@Override
		public PrepaidRate.PrepaidRateBuilder setFloatingRateIndex(FloatingRateIndex _floatingRateIndex) {
			this.floatingRateIndex = _floatingRateIndex == null ? null : _floatingRateIndex.toBuilder();
			return this;
		}
		
		@RosettaAttribute("indexTenor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexTenor")
		@Override
		public PrepaidRate.PrepaidRateBuilder setIndexTenor(Period _indexTenor) {
			this.indexTenor = _indexTenor == null ? null : _indexTenor.toBuilder();
			return this;
		}
		
		@Override
		public PrepaidRate build() {
			return new PrepaidRate.PrepaidRateImpl(this);
		}
		
		@Override
		public PrepaidRate.PrepaidRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrepaidRate.PrepaidRateBuilder prune() {
			if (floatingRateIndex!=null && !floatingRateIndex.prune().hasData()) floatingRateIndex = null;
			if (indexTenor!=null && !indexTenor.prune().hasData()) indexTenor = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFixedRate()!=null) return true;
			if (getFloatingRateIndex()!=null && getFloatingRateIndex().hasData()) return true;
			if (getIndexTenor()!=null && getIndexTenor().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrepaidRate.PrepaidRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PrepaidRate.PrepaidRateBuilder o = (PrepaidRate.PrepaidRateBuilder) other;
			
			merger.mergeRosetta(getFloatingRateIndex(), o.getFloatingRateIndex(), this::setFloatingRateIndex);
			merger.mergeRosetta(getIndexTenor(), o.getIndexTenor(), this::setIndexTenor);
			
			merger.mergeBasic(getFixedRate(), o.getFixedRate(), this::setFixedRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrepaidRate _that = getType().cast(o);
		
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(indexTenor, _that.getIndexTenor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrepaidRateBuilder {" +
				"fixedRate=" + this.fixedRate + ", " +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor +
			'}';
		}
	}
}

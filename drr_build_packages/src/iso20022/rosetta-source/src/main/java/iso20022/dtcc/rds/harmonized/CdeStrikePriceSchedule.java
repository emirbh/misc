package iso20022.dtcc.rds.harmonized;

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
import com.rosetta.model.lib.records.Date;
import iso20022.dtcc.rds.harmonized.meta.CdeStrikePriceScheduleMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CdeStrikePriceSchedule", builder=CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilderImpl.class, version="${project.version}")
@RuneDataType(value="CdeStrikePriceSchedule", model="iso20022", builder=CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilderImpl.class, version="${project.version}")
public interface CdeStrikePriceSchedule extends RosettaModelObject {

	CdeStrikePriceScheduleMeta metaData = new CdeStrikePriceScheduleMeta();

	/*********************** Getter Methods  ***********************/
	Date getCdeUnadjustedEffectiveDateOfStrikePrice();
	Date getCdeUnadjustedEndDateOfStrikePrice();
	BigDecimal getCdeStrikePrice();

	/*********************** Build Methods  ***********************/
	CdeStrikePriceSchedule build();
	
	CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder toBuilder();
	
	static CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder builder() {
		return new CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CdeStrikePriceSchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CdeStrikePriceSchedule> getType() {
		return CdeStrikePriceSchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("cdeUnadjustedEffectiveDateOfStrikePrice"), Date.class, getCdeUnadjustedEffectiveDateOfStrikePrice(), this);
		processor.processBasic(path.newSubPath("cdeUnadjustedEndDateOfStrikePrice"), Date.class, getCdeUnadjustedEndDateOfStrikePrice(), this);
		processor.processBasic(path.newSubPath("cdeStrikePrice"), BigDecimal.class, getCdeStrikePrice(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CdeStrikePriceScheduleBuilder extends CdeStrikePriceSchedule, RosettaModelObjectBuilder {
		CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder setCdeUnadjustedEffectiveDateOfStrikePrice(Date cdeUnadjustedEffectiveDateOfStrikePrice);
		CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder setCdeUnadjustedEndDateOfStrikePrice(Date cdeUnadjustedEndDateOfStrikePrice);
		CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder setCdeStrikePrice(BigDecimal cdeStrikePrice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("cdeUnadjustedEffectiveDateOfStrikePrice"), Date.class, getCdeUnadjustedEffectiveDateOfStrikePrice(), this);
			processor.processBasic(path.newSubPath("cdeUnadjustedEndDateOfStrikePrice"), Date.class, getCdeUnadjustedEndDateOfStrikePrice(), this);
			processor.processBasic(path.newSubPath("cdeStrikePrice"), BigDecimal.class, getCdeStrikePrice(), this);
		}
		

		CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of CdeStrikePriceSchedule  ***********************/
	class CdeStrikePriceScheduleImpl implements CdeStrikePriceSchedule {
		private final Date cdeUnadjustedEffectiveDateOfStrikePrice;
		private final Date cdeUnadjustedEndDateOfStrikePrice;
		private final BigDecimal cdeStrikePrice;
		
		protected CdeStrikePriceScheduleImpl(CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder builder) {
			this.cdeUnadjustedEffectiveDateOfStrikePrice = builder.getCdeUnadjustedEffectiveDateOfStrikePrice();
			this.cdeUnadjustedEndDateOfStrikePrice = builder.getCdeUnadjustedEndDateOfStrikePrice();
			this.cdeStrikePrice = builder.getCdeStrikePrice();
		}
		
		@Override
		@RosettaAttribute("cdeUnadjustedEffectiveDateOfStrikePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdeUnadjustedEffectiveDateOfStrikePrice")
		public Date getCdeUnadjustedEffectiveDateOfStrikePrice() {
			return cdeUnadjustedEffectiveDateOfStrikePrice;
		}
		
		@Override
		@RosettaAttribute("cdeUnadjustedEndDateOfStrikePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdeUnadjustedEndDateOfStrikePrice")
		public Date getCdeUnadjustedEndDateOfStrikePrice() {
			return cdeUnadjustedEndDateOfStrikePrice;
		}
		
		@Override
		@RosettaAttribute("cdeStrikePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdeStrikePrice")
		public BigDecimal getCdeStrikePrice() {
			return cdeStrikePrice;
		}
		
		@Override
		public CdeStrikePriceSchedule build() {
			return this;
		}
		
		@Override
		public CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder toBuilder() {
			CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder builder) {
			ofNullable(getCdeUnadjustedEffectiveDateOfStrikePrice()).ifPresent(builder::setCdeUnadjustedEffectiveDateOfStrikePrice);
			ofNullable(getCdeUnadjustedEndDateOfStrikePrice()).ifPresent(builder::setCdeUnadjustedEndDateOfStrikePrice);
			ofNullable(getCdeStrikePrice()).ifPresent(builder::setCdeStrikePrice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CdeStrikePriceSchedule _that = getType().cast(o);
		
			if (!Objects.equals(cdeUnadjustedEffectiveDateOfStrikePrice, _that.getCdeUnadjustedEffectiveDateOfStrikePrice())) return false;
			if (!Objects.equals(cdeUnadjustedEndDateOfStrikePrice, _that.getCdeUnadjustedEndDateOfStrikePrice())) return false;
			if (!Objects.equals(cdeStrikePrice, _that.getCdeStrikePrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cdeUnadjustedEffectiveDateOfStrikePrice != null ? cdeUnadjustedEffectiveDateOfStrikePrice.hashCode() : 0);
			_result = 31 * _result + (cdeUnadjustedEndDateOfStrikePrice != null ? cdeUnadjustedEndDateOfStrikePrice.hashCode() : 0);
			_result = 31 * _result + (cdeStrikePrice != null ? cdeStrikePrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CdeStrikePriceSchedule {" +
				"cdeUnadjustedEffectiveDateOfStrikePrice=" + this.cdeUnadjustedEffectiveDateOfStrikePrice + ", " +
				"cdeUnadjustedEndDateOfStrikePrice=" + this.cdeUnadjustedEndDateOfStrikePrice + ", " +
				"cdeStrikePrice=" + this.cdeStrikePrice +
			'}';
		}
	}

	/*********************** Builder Implementation of CdeStrikePriceSchedule  ***********************/
	class CdeStrikePriceScheduleBuilderImpl implements CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder {
	
		protected Date cdeUnadjustedEffectiveDateOfStrikePrice;
		protected Date cdeUnadjustedEndDateOfStrikePrice;
		protected BigDecimal cdeStrikePrice;
		
		@Override
		@RosettaAttribute("cdeUnadjustedEffectiveDateOfStrikePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdeUnadjustedEffectiveDateOfStrikePrice")
		public Date getCdeUnadjustedEffectiveDateOfStrikePrice() {
			return cdeUnadjustedEffectiveDateOfStrikePrice;
		}
		
		@Override
		@RosettaAttribute("cdeUnadjustedEndDateOfStrikePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdeUnadjustedEndDateOfStrikePrice")
		public Date getCdeUnadjustedEndDateOfStrikePrice() {
			return cdeUnadjustedEndDateOfStrikePrice;
		}
		
		@Override
		@RosettaAttribute("cdeStrikePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdeStrikePrice")
		public BigDecimal getCdeStrikePrice() {
			return cdeStrikePrice;
		}
		
		@RosettaAttribute("cdeUnadjustedEffectiveDateOfStrikePrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdeUnadjustedEffectiveDateOfStrikePrice")
		@Override
		public CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder setCdeUnadjustedEffectiveDateOfStrikePrice(Date _cdeUnadjustedEffectiveDateOfStrikePrice) {
			this.cdeUnadjustedEffectiveDateOfStrikePrice = _cdeUnadjustedEffectiveDateOfStrikePrice == null ? null : _cdeUnadjustedEffectiveDateOfStrikePrice;
			return this;
		}
		
		@RosettaAttribute("cdeUnadjustedEndDateOfStrikePrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdeUnadjustedEndDateOfStrikePrice")
		@Override
		public CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder setCdeUnadjustedEndDateOfStrikePrice(Date _cdeUnadjustedEndDateOfStrikePrice) {
			this.cdeUnadjustedEndDateOfStrikePrice = _cdeUnadjustedEndDateOfStrikePrice == null ? null : _cdeUnadjustedEndDateOfStrikePrice;
			return this;
		}
		
		@RosettaAttribute("cdeStrikePrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdeStrikePrice")
		@Override
		public CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder setCdeStrikePrice(BigDecimal _cdeStrikePrice) {
			this.cdeStrikePrice = _cdeStrikePrice == null ? null : _cdeStrikePrice;
			return this;
		}
		
		@Override
		public CdeStrikePriceSchedule build() {
			return new CdeStrikePriceSchedule.CdeStrikePriceScheduleImpl(this);
		}
		
		@Override
		public CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCdeUnadjustedEffectiveDateOfStrikePrice()!=null) return true;
			if (getCdeUnadjustedEndDateOfStrikePrice()!=null) return true;
			if (getCdeStrikePrice()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder o = (CdeStrikePriceSchedule.CdeStrikePriceScheduleBuilder) other;
			
			
			merger.mergeBasic(getCdeUnadjustedEffectiveDateOfStrikePrice(), o.getCdeUnadjustedEffectiveDateOfStrikePrice(), this::setCdeUnadjustedEffectiveDateOfStrikePrice);
			merger.mergeBasic(getCdeUnadjustedEndDateOfStrikePrice(), o.getCdeUnadjustedEndDateOfStrikePrice(), this::setCdeUnadjustedEndDateOfStrikePrice);
			merger.mergeBasic(getCdeStrikePrice(), o.getCdeStrikePrice(), this::setCdeStrikePrice);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CdeStrikePriceSchedule _that = getType().cast(o);
		
			if (!Objects.equals(cdeUnadjustedEffectiveDateOfStrikePrice, _that.getCdeUnadjustedEffectiveDateOfStrikePrice())) return false;
			if (!Objects.equals(cdeUnadjustedEndDateOfStrikePrice, _that.getCdeUnadjustedEndDateOfStrikePrice())) return false;
			if (!Objects.equals(cdeStrikePrice, _that.getCdeStrikePrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cdeUnadjustedEffectiveDateOfStrikePrice != null ? cdeUnadjustedEffectiveDateOfStrikePrice.hashCode() : 0);
			_result = 31 * _result + (cdeUnadjustedEndDateOfStrikePrice != null ? cdeUnadjustedEndDateOfStrikePrice.hashCode() : 0);
			_result = 31 * _result + (cdeStrikePrice != null ? cdeStrikePrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CdeStrikePriceScheduleBuilder {" +
				"cdeUnadjustedEffectiveDateOfStrikePrice=" + this.cdeUnadjustedEffectiveDateOfStrikePrice + ", " +
				"cdeUnadjustedEndDateOfStrikePrice=" + this.cdeUnadjustedEndDateOfStrikePrice + ", " +
				"cdeStrikePrice=" + this.cdeStrikePrice +
			'}';
		}
	}
}

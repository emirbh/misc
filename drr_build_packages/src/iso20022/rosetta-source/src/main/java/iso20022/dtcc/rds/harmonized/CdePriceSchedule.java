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
import iso20022.dtcc.rds.harmonized.meta.CdePriceScheduleMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CdePriceSchedule", builder=CdePriceSchedule.CdePriceScheduleBuilderImpl.class, version="${project.version}")
@RuneDataType(value="CdePriceSchedule", model="iso20022", builder=CdePriceSchedule.CdePriceScheduleBuilderImpl.class, version="${project.version}")
public interface CdePriceSchedule extends RosettaModelObject {

	CdePriceScheduleMeta metaData = new CdePriceScheduleMeta();

	/*********************** Getter Methods  ***********************/
	Date getCdeUnadjustedEffectiveDateOfPrice();
	Date getCdeUnadjustedEndDateOfPrice();
	BigDecimal getCdePrice();

	/*********************** Build Methods  ***********************/
	CdePriceSchedule build();
	
	CdePriceSchedule.CdePriceScheduleBuilder toBuilder();
	
	static CdePriceSchedule.CdePriceScheduleBuilder builder() {
		return new CdePriceSchedule.CdePriceScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CdePriceSchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CdePriceSchedule> getType() {
		return CdePriceSchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("cdeUnadjustedEffectiveDateOfPrice"), Date.class, getCdeUnadjustedEffectiveDateOfPrice(), this);
		processor.processBasic(path.newSubPath("cdeUnadjustedEndDateOfPrice"), Date.class, getCdeUnadjustedEndDateOfPrice(), this);
		processor.processBasic(path.newSubPath("cdePrice"), BigDecimal.class, getCdePrice(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CdePriceScheduleBuilder extends CdePriceSchedule, RosettaModelObjectBuilder {
		CdePriceSchedule.CdePriceScheduleBuilder setCdeUnadjustedEffectiveDateOfPrice(Date cdeUnadjustedEffectiveDateOfPrice);
		CdePriceSchedule.CdePriceScheduleBuilder setCdeUnadjustedEndDateOfPrice(Date cdeUnadjustedEndDateOfPrice);
		CdePriceSchedule.CdePriceScheduleBuilder setCdePrice(BigDecimal cdePrice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("cdeUnadjustedEffectiveDateOfPrice"), Date.class, getCdeUnadjustedEffectiveDateOfPrice(), this);
			processor.processBasic(path.newSubPath("cdeUnadjustedEndDateOfPrice"), Date.class, getCdeUnadjustedEndDateOfPrice(), this);
			processor.processBasic(path.newSubPath("cdePrice"), BigDecimal.class, getCdePrice(), this);
		}
		

		CdePriceSchedule.CdePriceScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of CdePriceSchedule  ***********************/
	class CdePriceScheduleImpl implements CdePriceSchedule {
		private final Date cdeUnadjustedEffectiveDateOfPrice;
		private final Date cdeUnadjustedEndDateOfPrice;
		private final BigDecimal cdePrice;
		
		protected CdePriceScheduleImpl(CdePriceSchedule.CdePriceScheduleBuilder builder) {
			this.cdeUnadjustedEffectiveDateOfPrice = builder.getCdeUnadjustedEffectiveDateOfPrice();
			this.cdeUnadjustedEndDateOfPrice = builder.getCdeUnadjustedEndDateOfPrice();
			this.cdePrice = builder.getCdePrice();
		}
		
		@Override
		@RosettaAttribute("cdeUnadjustedEffectiveDateOfPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdeUnadjustedEffectiveDateOfPrice")
		public Date getCdeUnadjustedEffectiveDateOfPrice() {
			return cdeUnadjustedEffectiveDateOfPrice;
		}
		
		@Override
		@RosettaAttribute("cdeUnadjustedEndDateOfPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdeUnadjustedEndDateOfPrice")
		public Date getCdeUnadjustedEndDateOfPrice() {
			return cdeUnadjustedEndDateOfPrice;
		}
		
		@Override
		@RosettaAttribute("cdePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdePrice")
		public BigDecimal getCdePrice() {
			return cdePrice;
		}
		
		@Override
		public CdePriceSchedule build() {
			return this;
		}
		
		@Override
		public CdePriceSchedule.CdePriceScheduleBuilder toBuilder() {
			CdePriceSchedule.CdePriceScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CdePriceSchedule.CdePriceScheduleBuilder builder) {
			ofNullable(getCdeUnadjustedEffectiveDateOfPrice()).ifPresent(builder::setCdeUnadjustedEffectiveDateOfPrice);
			ofNullable(getCdeUnadjustedEndDateOfPrice()).ifPresent(builder::setCdeUnadjustedEndDateOfPrice);
			ofNullable(getCdePrice()).ifPresent(builder::setCdePrice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CdePriceSchedule _that = getType().cast(o);
		
			if (!Objects.equals(cdeUnadjustedEffectiveDateOfPrice, _that.getCdeUnadjustedEffectiveDateOfPrice())) return false;
			if (!Objects.equals(cdeUnadjustedEndDateOfPrice, _that.getCdeUnadjustedEndDateOfPrice())) return false;
			if (!Objects.equals(cdePrice, _that.getCdePrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cdeUnadjustedEffectiveDateOfPrice != null ? cdeUnadjustedEffectiveDateOfPrice.hashCode() : 0);
			_result = 31 * _result + (cdeUnadjustedEndDateOfPrice != null ? cdeUnadjustedEndDateOfPrice.hashCode() : 0);
			_result = 31 * _result + (cdePrice != null ? cdePrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CdePriceSchedule {" +
				"cdeUnadjustedEffectiveDateOfPrice=" + this.cdeUnadjustedEffectiveDateOfPrice + ", " +
				"cdeUnadjustedEndDateOfPrice=" + this.cdeUnadjustedEndDateOfPrice + ", " +
				"cdePrice=" + this.cdePrice +
			'}';
		}
	}

	/*********************** Builder Implementation of CdePriceSchedule  ***********************/
	class CdePriceScheduleBuilderImpl implements CdePriceSchedule.CdePriceScheduleBuilder {
	
		protected Date cdeUnadjustedEffectiveDateOfPrice;
		protected Date cdeUnadjustedEndDateOfPrice;
		protected BigDecimal cdePrice;
		
		@Override
		@RosettaAttribute("cdeUnadjustedEffectiveDateOfPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdeUnadjustedEffectiveDateOfPrice")
		public Date getCdeUnadjustedEffectiveDateOfPrice() {
			return cdeUnadjustedEffectiveDateOfPrice;
		}
		
		@Override
		@RosettaAttribute("cdeUnadjustedEndDateOfPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdeUnadjustedEndDateOfPrice")
		public Date getCdeUnadjustedEndDateOfPrice() {
			return cdeUnadjustedEndDateOfPrice;
		}
		
		@Override
		@RosettaAttribute("cdePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdePrice")
		public BigDecimal getCdePrice() {
			return cdePrice;
		}
		
		@RosettaAttribute("cdeUnadjustedEffectiveDateOfPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdeUnadjustedEffectiveDateOfPrice")
		@Override
		public CdePriceSchedule.CdePriceScheduleBuilder setCdeUnadjustedEffectiveDateOfPrice(Date _cdeUnadjustedEffectiveDateOfPrice) {
			this.cdeUnadjustedEffectiveDateOfPrice = _cdeUnadjustedEffectiveDateOfPrice == null ? null : _cdeUnadjustedEffectiveDateOfPrice;
			return this;
		}
		
		@RosettaAttribute("cdeUnadjustedEndDateOfPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdeUnadjustedEndDateOfPrice")
		@Override
		public CdePriceSchedule.CdePriceScheduleBuilder setCdeUnadjustedEndDateOfPrice(Date _cdeUnadjustedEndDateOfPrice) {
			this.cdeUnadjustedEndDateOfPrice = _cdeUnadjustedEndDateOfPrice == null ? null : _cdeUnadjustedEndDateOfPrice;
			return this;
		}
		
		@RosettaAttribute("cdePrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdePrice")
		@Override
		public CdePriceSchedule.CdePriceScheduleBuilder setCdePrice(BigDecimal _cdePrice) {
			this.cdePrice = _cdePrice == null ? null : _cdePrice;
			return this;
		}
		
		@Override
		public CdePriceSchedule build() {
			return new CdePriceSchedule.CdePriceScheduleImpl(this);
		}
		
		@Override
		public CdePriceSchedule.CdePriceScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CdePriceSchedule.CdePriceScheduleBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCdeUnadjustedEffectiveDateOfPrice()!=null) return true;
			if (getCdeUnadjustedEndDateOfPrice()!=null) return true;
			if (getCdePrice()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CdePriceSchedule.CdePriceScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CdePriceSchedule.CdePriceScheduleBuilder o = (CdePriceSchedule.CdePriceScheduleBuilder) other;
			
			
			merger.mergeBasic(getCdeUnadjustedEffectiveDateOfPrice(), o.getCdeUnadjustedEffectiveDateOfPrice(), this::setCdeUnadjustedEffectiveDateOfPrice);
			merger.mergeBasic(getCdeUnadjustedEndDateOfPrice(), o.getCdeUnadjustedEndDateOfPrice(), this::setCdeUnadjustedEndDateOfPrice);
			merger.mergeBasic(getCdePrice(), o.getCdePrice(), this::setCdePrice);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CdePriceSchedule _that = getType().cast(o);
		
			if (!Objects.equals(cdeUnadjustedEffectiveDateOfPrice, _that.getCdeUnadjustedEffectiveDateOfPrice())) return false;
			if (!Objects.equals(cdeUnadjustedEndDateOfPrice, _that.getCdeUnadjustedEndDateOfPrice())) return false;
			if (!Objects.equals(cdePrice, _that.getCdePrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cdeUnadjustedEffectiveDateOfPrice != null ? cdeUnadjustedEffectiveDateOfPrice.hashCode() : 0);
			_result = 31 * _result + (cdeUnadjustedEndDateOfPrice != null ? cdeUnadjustedEndDateOfPrice.hashCode() : 0);
			_result = 31 * _result + (cdePrice != null ? cdePrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CdePriceScheduleBuilder {" +
				"cdeUnadjustedEffectiveDateOfPrice=" + this.cdeUnadjustedEffectiveDateOfPrice + ", " +
				"cdeUnadjustedEndDateOfPrice=" + this.cdeUnadjustedEndDateOfPrice + ", " +
				"cdePrice=" + this.cdePrice +
			'}';
		}
	}
}

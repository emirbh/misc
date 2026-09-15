package iso20022.auth030.hkma.tr;

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
import com.rosetta.model.lib.records.Date;
import iso20022.auth030.hkma.tr.meta.Schedule10__1Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Indicates the unadjusted effective and end date of the schedule.
 * @version ${project.version}
 */
@RosettaDataType(value="Schedule10__1", builder=Schedule10__1.Schedule10__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="Schedule10__1", model="iso20022", builder=Schedule10__1.Schedule10__1BuilderImpl.class, version="${project.version}")
public interface Schedule10__1 extends RosettaModelObject {

	Schedule10__1Meta metaData = new Schedule10__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Number of units of the financial instrument, that is, the nominal value.
	 */
	BigDecimal getQty();
	/**
	 * Indicates the unadjusted date at which obligations under the  derivative transaction come into effect, as included in the confirmation.
	 */
	Date getUadjstdFctvDt();
	/**
	 * Indicates the end date agreed in the derivative transaction without adjustment.
	 */
	Date getUadjstdEndDt();

	/*********************** Build Methods  ***********************/
	Schedule10__1 build();
	
	Schedule10__1.Schedule10__1Builder toBuilder();
	
	static Schedule10__1.Schedule10__1Builder builder() {
		return new Schedule10__1.Schedule10__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Schedule10__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Schedule10__1> getType() {
		return Schedule10__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("qty"), BigDecimal.class, getQty(), this);
		processor.processBasic(path.newSubPath("uadjstdFctvDt"), Date.class, getUadjstdFctvDt(), this);
		processor.processBasic(path.newSubPath("uadjstdEndDt"), Date.class, getUadjstdEndDt(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface Schedule10__1Builder extends Schedule10__1, RosettaModelObjectBuilder {
		Schedule10__1.Schedule10__1Builder setQty(BigDecimal qty);
		Schedule10__1.Schedule10__1Builder setUadjstdFctvDt(Date uadjstdFctvDt);
		Schedule10__1.Schedule10__1Builder setUadjstdEndDt(Date uadjstdEndDt);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("qty"), BigDecimal.class, getQty(), this);
			processor.processBasic(path.newSubPath("uadjstdFctvDt"), Date.class, getUadjstdFctvDt(), this);
			processor.processBasic(path.newSubPath("uadjstdEndDt"), Date.class, getUadjstdEndDt(), this);
		}
		

		Schedule10__1.Schedule10__1Builder prune();
	}

	/*********************** Immutable Implementation of Schedule10__1  ***********************/
	class Schedule10__1Impl implements Schedule10__1 {
		private final BigDecimal qty;
		private final Date uadjstdFctvDt;
		private final Date uadjstdEndDt;
		
		protected Schedule10__1Impl(Schedule10__1.Schedule10__1Builder builder) {
			this.qty = builder.getQty();
			this.uadjstdFctvDt = builder.getUadjstdFctvDt();
			this.uadjstdEndDt = builder.getUadjstdEndDt();
		}
		
		@Override
		@RosettaAttribute("qty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("qty")
		public BigDecimal getQty() {
			return qty;
		}
		
		@Override
		@RosettaAttribute("uadjstdFctvDt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("uadjstdFctvDt")
		public Date getUadjstdFctvDt() {
			return uadjstdFctvDt;
		}
		
		@Override
		@RosettaAttribute("uadjstdEndDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uadjstdEndDt")
		public Date getUadjstdEndDt() {
			return uadjstdEndDt;
		}
		
		@Override
		public Schedule10__1 build() {
			return this;
		}
		
		@Override
		public Schedule10__1.Schedule10__1Builder toBuilder() {
			Schedule10__1.Schedule10__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Schedule10__1.Schedule10__1Builder builder) {
			ofNullable(getQty()).ifPresent(builder::setQty);
			ofNullable(getUadjstdFctvDt()).ifPresent(builder::setUadjstdFctvDt);
			ofNullable(getUadjstdEndDt()).ifPresent(builder::setUadjstdEndDt);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Schedule10__1 _that = getType().cast(o);
		
			if (!Objects.equals(qty, _that.getQty())) return false;
			if (!Objects.equals(uadjstdFctvDt, _that.getUadjstdFctvDt())) return false;
			if (!Objects.equals(uadjstdEndDt, _that.getUadjstdEndDt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (qty != null ? qty.hashCode() : 0);
			_result = 31 * _result + (uadjstdFctvDt != null ? uadjstdFctvDt.hashCode() : 0);
			_result = 31 * _result + (uadjstdEndDt != null ? uadjstdEndDt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Schedule10__1 {" +
				"qty=" + this.qty + ", " +
				"uadjstdFctvDt=" + this.uadjstdFctvDt + ", " +
				"uadjstdEndDt=" + this.uadjstdEndDt +
			'}';
		}
	}

	/*********************** Builder Implementation of Schedule10__1  ***********************/
	class Schedule10__1BuilderImpl implements Schedule10__1.Schedule10__1Builder {
	
		protected BigDecimal qty;
		protected Date uadjstdFctvDt;
		protected Date uadjstdEndDt;
		
		@Override
		@RosettaAttribute("qty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("qty")
		public BigDecimal getQty() {
			return qty;
		}
		
		@Override
		@RosettaAttribute("uadjstdFctvDt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("uadjstdFctvDt")
		public Date getUadjstdFctvDt() {
			return uadjstdFctvDt;
		}
		
		@Override
		@RosettaAttribute("uadjstdEndDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uadjstdEndDt")
		public Date getUadjstdEndDt() {
			return uadjstdEndDt;
		}
		
		@RosettaAttribute("qty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("qty")
		@Override
		public Schedule10__1.Schedule10__1Builder setQty(BigDecimal _qty) {
			this.qty = _qty == null ? null : _qty;
			return this;
		}
		
		@RosettaAttribute("uadjstdFctvDt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("uadjstdFctvDt")
		@Override
		public Schedule10__1.Schedule10__1Builder setUadjstdFctvDt(Date _uadjstdFctvDt) {
			this.uadjstdFctvDt = _uadjstdFctvDt == null ? null : _uadjstdFctvDt;
			return this;
		}
		
		@RosettaAttribute("uadjstdEndDt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uadjstdEndDt")
		@Override
		public Schedule10__1.Schedule10__1Builder setUadjstdEndDt(Date _uadjstdEndDt) {
			this.uadjstdEndDt = _uadjstdEndDt == null ? null : _uadjstdEndDt;
			return this;
		}
		
		@Override
		public Schedule10__1 build() {
			return new Schedule10__1.Schedule10__1Impl(this);
		}
		
		@Override
		public Schedule10__1.Schedule10__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Schedule10__1.Schedule10__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQty()!=null) return true;
			if (getUadjstdFctvDt()!=null) return true;
			if (getUadjstdEndDt()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Schedule10__1.Schedule10__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Schedule10__1.Schedule10__1Builder o = (Schedule10__1.Schedule10__1Builder) other;
			
			
			merger.mergeBasic(getQty(), o.getQty(), this::setQty);
			merger.mergeBasic(getUadjstdFctvDt(), o.getUadjstdFctvDt(), this::setUadjstdFctvDt);
			merger.mergeBasic(getUadjstdEndDt(), o.getUadjstdEndDt(), this::setUadjstdEndDt);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Schedule10__1 _that = getType().cast(o);
		
			if (!Objects.equals(qty, _that.getQty())) return false;
			if (!Objects.equals(uadjstdFctvDt, _that.getUadjstdFctvDt())) return false;
			if (!Objects.equals(uadjstdEndDt, _that.getUadjstdEndDt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (qty != null ? qty.hashCode() : 0);
			_result = 31 * _result + (uadjstdFctvDt != null ? uadjstdFctvDt.hashCode() : 0);
			_result = 31 * _result + (uadjstdEndDt != null ? uadjstdEndDt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Schedule10__1Builder {" +
				"qty=" + this.qty + ", " +
				"uadjstdFctvDt=" + this.uadjstdFctvDt + ", " +
				"uadjstdEndDt=" + this.uadjstdEndDt +
			'}';
		}
	}
}

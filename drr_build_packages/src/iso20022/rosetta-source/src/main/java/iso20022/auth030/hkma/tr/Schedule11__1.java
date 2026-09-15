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
import iso20022.auth030.hkma.tr.meta.Schedule11__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Indicates the unadjusted effective and end date of the schedule.
 * @version ${project.version}
 */
@RosettaDataType(value="Schedule11__1", builder=Schedule11__1.Schedule11__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="Schedule11__1", model="iso20022", builder=Schedule11__1.Schedule11__1BuilderImpl.class, version="${project.version}")
public interface Schedule11__1 extends RosettaModelObject {

	Schedule11__1Meta metaData = new Schedule11__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates the unadjusted date at which obligations under the  derivative transaction come into effect, as included in the confirmation.
	 */
	Date getUadjstdFctvDt();
	/**
	 * Indicates the end date agreed in the derivative transaction without adjustment.
	 */
	Date getUadjstdEndDt();
	/**
	 * Indicates the price per derivative excluding, where applicable, commission and accrued interest.
	 */
	AmountAndDirection106__2 getAmt();

	/*********************** Build Methods  ***********************/
	Schedule11__1 build();
	
	Schedule11__1.Schedule11__1Builder toBuilder();
	
	static Schedule11__1.Schedule11__1Builder builder() {
		return new Schedule11__1.Schedule11__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Schedule11__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Schedule11__1> getType() {
		return Schedule11__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("uadjstdFctvDt"), Date.class, getUadjstdFctvDt(), this);
		processor.processBasic(path.newSubPath("uadjstdEndDt"), Date.class, getUadjstdEndDt(), this);
		processRosetta(path.newSubPath("amt"), processor, AmountAndDirection106__2.class, getAmt());
	}
	

	/*********************** Builder Interface  ***********************/
	interface Schedule11__1Builder extends Schedule11__1, RosettaModelObjectBuilder {
		AmountAndDirection106__2.AmountAndDirection106__2Builder getOrCreateAmt();
		@Override
		AmountAndDirection106__2.AmountAndDirection106__2Builder getAmt();
		Schedule11__1.Schedule11__1Builder setUadjstdFctvDt(Date uadjstdFctvDt);
		Schedule11__1.Schedule11__1Builder setUadjstdEndDt(Date uadjstdEndDt);
		Schedule11__1.Schedule11__1Builder setAmt(AmountAndDirection106__2 amt);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("uadjstdFctvDt"), Date.class, getUadjstdFctvDt(), this);
			processor.processBasic(path.newSubPath("uadjstdEndDt"), Date.class, getUadjstdEndDt(), this);
			processRosetta(path.newSubPath("amt"), processor, AmountAndDirection106__2.AmountAndDirection106__2Builder.class, getAmt());
		}
		

		Schedule11__1.Schedule11__1Builder prune();
	}

	/*********************** Immutable Implementation of Schedule11__1  ***********************/
	class Schedule11__1Impl implements Schedule11__1 {
		private final Date uadjstdFctvDt;
		private final Date uadjstdEndDt;
		private final AmountAndDirection106__2 amt;
		
		protected Schedule11__1Impl(Schedule11__1.Schedule11__1Builder builder) {
			this.uadjstdFctvDt = builder.getUadjstdFctvDt();
			this.uadjstdEndDt = builder.getUadjstdEndDt();
			this.amt = ofNullable(builder.getAmt()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("amt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amt")
		public AmountAndDirection106__2 getAmt() {
			return amt;
		}
		
		@Override
		public Schedule11__1 build() {
			return this;
		}
		
		@Override
		public Schedule11__1.Schedule11__1Builder toBuilder() {
			Schedule11__1.Schedule11__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Schedule11__1.Schedule11__1Builder builder) {
			ofNullable(getUadjstdFctvDt()).ifPresent(builder::setUadjstdFctvDt);
			ofNullable(getUadjstdEndDt()).ifPresent(builder::setUadjstdEndDt);
			ofNullable(getAmt()).ifPresent(builder::setAmt);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Schedule11__1 _that = getType().cast(o);
		
			if (!Objects.equals(uadjstdFctvDt, _that.getUadjstdFctvDt())) return false;
			if (!Objects.equals(uadjstdEndDt, _that.getUadjstdEndDt())) return false;
			if (!Objects.equals(amt, _that.getAmt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (uadjstdFctvDt != null ? uadjstdFctvDt.hashCode() : 0);
			_result = 31 * _result + (uadjstdEndDt != null ? uadjstdEndDt.hashCode() : 0);
			_result = 31 * _result + (amt != null ? amt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Schedule11__1 {" +
				"uadjstdFctvDt=" + this.uadjstdFctvDt + ", " +
				"uadjstdEndDt=" + this.uadjstdEndDt + ", " +
				"amt=" + this.amt +
			'}';
		}
	}

	/*********************** Builder Implementation of Schedule11__1  ***********************/
	class Schedule11__1BuilderImpl implements Schedule11__1.Schedule11__1Builder {
	
		protected Date uadjstdFctvDt;
		protected Date uadjstdEndDt;
		protected AmountAndDirection106__2.AmountAndDirection106__2Builder amt;
		
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
		@RosettaAttribute("amt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amt")
		public AmountAndDirection106__2.AmountAndDirection106__2Builder getAmt() {
			return amt;
		}
		
		@Override
		public AmountAndDirection106__2.AmountAndDirection106__2Builder getOrCreateAmt() {
			AmountAndDirection106__2.AmountAndDirection106__2Builder result;
			if (amt!=null) {
				result = amt;
			}
			else {
				result = amt = AmountAndDirection106__2.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("uadjstdFctvDt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("uadjstdFctvDt")
		@Override
		public Schedule11__1.Schedule11__1Builder setUadjstdFctvDt(Date _uadjstdFctvDt) {
			this.uadjstdFctvDt = _uadjstdFctvDt == null ? null : _uadjstdFctvDt;
			return this;
		}
		
		@RosettaAttribute("uadjstdEndDt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uadjstdEndDt")
		@Override
		public Schedule11__1.Schedule11__1Builder setUadjstdEndDt(Date _uadjstdEndDt) {
			this.uadjstdEndDt = _uadjstdEndDt == null ? null : _uadjstdEndDt;
			return this;
		}
		
		@RosettaAttribute("amt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amt")
		@Override
		public Schedule11__1.Schedule11__1Builder setAmt(AmountAndDirection106__2 _amt) {
			this.amt = _amt == null ? null : _amt.toBuilder();
			return this;
		}
		
		@Override
		public Schedule11__1 build() {
			return new Schedule11__1.Schedule11__1Impl(this);
		}
		
		@Override
		public Schedule11__1.Schedule11__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Schedule11__1.Schedule11__1Builder prune() {
			if (amt!=null && !amt.prune().hasData()) amt = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUadjstdFctvDt()!=null) return true;
			if (getUadjstdEndDt()!=null) return true;
			if (getAmt()!=null && getAmt().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Schedule11__1.Schedule11__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Schedule11__1.Schedule11__1Builder o = (Schedule11__1.Schedule11__1Builder) other;
			
			merger.mergeRosetta(getAmt(), o.getAmt(), this::setAmt);
			
			merger.mergeBasic(getUadjstdFctvDt(), o.getUadjstdFctvDt(), this::setUadjstdFctvDt);
			merger.mergeBasic(getUadjstdEndDt(), o.getUadjstdEndDt(), this::setUadjstdEndDt);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Schedule11__1 _that = getType().cast(o);
		
			if (!Objects.equals(uadjstdFctvDt, _that.getUadjstdFctvDt())) return false;
			if (!Objects.equals(uadjstdEndDt, _that.getUadjstdEndDt())) return false;
			if (!Objects.equals(amt, _that.getAmt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (uadjstdFctvDt != null ? uadjstdFctvDt.hashCode() : 0);
			_result = 31 * _result + (uadjstdEndDt != null ? uadjstdEndDt.hashCode() : 0);
			_result = 31 * _result + (amt != null ? amt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Schedule11__1Builder {" +
				"uadjstdFctvDt=" + this.uadjstdFctvDt + ", " +
				"uadjstdEndDt=" + this.uadjstdEndDt + ", " +
				"amt=" + this.amt +
			'}';
		}
	}
}

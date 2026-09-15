package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.DatePeriod1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Range of time defined by a start date and an end date.
 * @version ${project.version}
 */
@RosettaDataType(value="DatePeriod1", builder=DatePeriod1.DatePeriod1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="DatePeriod1", model="iso20022", builder=DatePeriod1.DatePeriod1BuilderImpl.class, version="${project.version}")
public interface DatePeriod1 extends RosettaModelObject {

	DatePeriod1Meta metaData = new DatePeriod1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Start date of the range.
	 */
	Date getFrDt();
	/**
	 * End date of the range.
	 */
	Date getToDt();

	/*********************** Build Methods  ***********************/
	DatePeriod1 build();
	
	DatePeriod1.DatePeriod1Builder toBuilder();
	
	static DatePeriod1.DatePeriod1Builder builder() {
		return new DatePeriod1.DatePeriod1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DatePeriod1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DatePeriod1> getType() {
		return DatePeriod1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("frDt"), Date.class, getFrDt(), this);
		processor.processBasic(path.newSubPath("toDt"), Date.class, getToDt(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DatePeriod1Builder extends DatePeriod1, RosettaModelObjectBuilder {
		DatePeriod1.DatePeriod1Builder setFrDt(Date frDt);
		DatePeriod1.DatePeriod1Builder setToDt(Date toDt);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("frDt"), Date.class, getFrDt(), this);
			processor.processBasic(path.newSubPath("toDt"), Date.class, getToDt(), this);
		}
		

		DatePeriod1.DatePeriod1Builder prune();
	}

	/*********************** Immutable Implementation of DatePeriod1  ***********************/
	class DatePeriod1Impl implements DatePeriod1 {
		private final Date frDt;
		private final Date toDt;
		
		protected DatePeriod1Impl(DatePeriod1.DatePeriod1Builder builder) {
			this.frDt = builder.getFrDt();
			this.toDt = builder.getToDt();
		}
		
		@Override
		@RosettaAttribute("frDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("frDt")
		public Date getFrDt() {
			return frDt;
		}
		
		@Override
		@RosettaAttribute("toDt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("toDt")
		public Date getToDt() {
			return toDt;
		}
		
		@Override
		public DatePeriod1 build() {
			return this;
		}
		
		@Override
		public DatePeriod1.DatePeriod1Builder toBuilder() {
			DatePeriod1.DatePeriod1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DatePeriod1.DatePeriod1Builder builder) {
			ofNullable(getFrDt()).ifPresent(builder::setFrDt);
			ofNullable(getToDt()).ifPresent(builder::setToDt);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DatePeriod1 _that = getType().cast(o);
		
			if (!Objects.equals(frDt, _that.getFrDt())) return false;
			if (!Objects.equals(toDt, _that.getToDt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (frDt != null ? frDt.hashCode() : 0);
			_result = 31 * _result + (toDt != null ? toDt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DatePeriod1 {" +
				"frDt=" + this.frDt + ", " +
				"toDt=" + this.toDt +
			'}';
		}
	}

	/*********************** Builder Implementation of DatePeriod1  ***********************/
	class DatePeriod1BuilderImpl implements DatePeriod1.DatePeriod1Builder {
	
		protected Date frDt;
		protected Date toDt;
		
		@Override
		@RosettaAttribute("frDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("frDt")
		public Date getFrDt() {
			return frDt;
		}
		
		@Override
		@RosettaAttribute("toDt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("toDt")
		public Date getToDt() {
			return toDt;
		}
		
		@RosettaAttribute("frDt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("frDt")
		@Override
		public DatePeriod1.DatePeriod1Builder setFrDt(Date _frDt) {
			this.frDt = _frDt == null ? null : _frDt;
			return this;
		}
		
		@RosettaAttribute("toDt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("toDt")
		@Override
		public DatePeriod1.DatePeriod1Builder setToDt(Date _toDt) {
			this.toDt = _toDt == null ? null : _toDt;
			return this;
		}
		
		@Override
		public DatePeriod1 build() {
			return new DatePeriod1.DatePeriod1Impl(this);
		}
		
		@Override
		public DatePeriod1.DatePeriod1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DatePeriod1.DatePeriod1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFrDt()!=null) return true;
			if (getToDt()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DatePeriod1.DatePeriod1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DatePeriod1.DatePeriod1Builder o = (DatePeriod1.DatePeriod1Builder) other;
			
			
			merger.mergeBasic(getFrDt(), o.getFrDt(), this::setFrDt);
			merger.mergeBasic(getToDt(), o.getToDt(), this::setToDt);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DatePeriod1 _that = getType().cast(o);
		
			if (!Objects.equals(frDt, _that.getFrDt())) return false;
			if (!Objects.equals(toDt, _that.getToDt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (frDt != null ? frDt.hashCode() : 0);
			_result = 31 * _result + (toDt != null ? toDt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DatePeriod1Builder {" +
				"frDt=" + this.frDt + ", " +
				"toDt=" + this.toDt +
			'}';
		}
	}
}

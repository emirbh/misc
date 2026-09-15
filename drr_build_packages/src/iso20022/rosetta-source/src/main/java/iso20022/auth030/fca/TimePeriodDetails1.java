package iso20022.auth030.fca;

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
import iso20022.auth030.fca.meta.TimePeriodDetails1Meta;
import java.time.LocalTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Particular time span specified between a start time and an end time. The time period cannot exceed 24 hours.
 * @version ${project.version}
 */
@RosettaDataType(value="TimePeriodDetails1", builder=TimePeriodDetails1.TimePeriodDetails1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TimePeriodDetails1", model="iso20022", builder=TimePeriodDetails1.TimePeriodDetails1BuilderImpl.class, version="${project.version}")
public interface TimePeriodDetails1 extends RosettaModelObject {

	TimePeriodDetails1Meta metaData = new TimePeriodDetails1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Time at which the time span starts.
	 */
	LocalTime getFrTm();
	/**
	 * Time at which the time span ends.
	 */
	LocalTime getToTm();

	/*********************** Build Methods  ***********************/
	TimePeriodDetails1 build();
	
	TimePeriodDetails1.TimePeriodDetails1Builder toBuilder();
	
	static TimePeriodDetails1.TimePeriodDetails1Builder builder() {
		return new TimePeriodDetails1.TimePeriodDetails1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TimePeriodDetails1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TimePeriodDetails1> getType() {
		return TimePeriodDetails1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("frTm"), LocalTime.class, getFrTm(), this);
		processor.processBasic(path.newSubPath("toTm"), LocalTime.class, getToTm(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TimePeriodDetails1Builder extends TimePeriodDetails1, RosettaModelObjectBuilder {
		TimePeriodDetails1.TimePeriodDetails1Builder setFrTm(LocalTime frTm);
		TimePeriodDetails1.TimePeriodDetails1Builder setToTm(LocalTime toTm);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("frTm"), LocalTime.class, getFrTm(), this);
			processor.processBasic(path.newSubPath("toTm"), LocalTime.class, getToTm(), this);
		}
		

		TimePeriodDetails1.TimePeriodDetails1Builder prune();
	}

	/*********************** Immutable Implementation of TimePeriodDetails1  ***********************/
	class TimePeriodDetails1Impl implements TimePeriodDetails1 {
		private final LocalTime frTm;
		private final LocalTime toTm;
		
		protected TimePeriodDetails1Impl(TimePeriodDetails1.TimePeriodDetails1Builder builder) {
			this.frTm = builder.getFrTm();
			this.toTm = builder.getToTm();
		}
		
		@Override
		@RosettaAttribute("frTm")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("frTm")
		public LocalTime getFrTm() {
			return frTm;
		}
		
		@Override
		@RosettaAttribute("toTm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("toTm")
		public LocalTime getToTm() {
			return toTm;
		}
		
		@Override
		public TimePeriodDetails1 build() {
			return this;
		}
		
		@Override
		public TimePeriodDetails1.TimePeriodDetails1Builder toBuilder() {
			TimePeriodDetails1.TimePeriodDetails1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TimePeriodDetails1.TimePeriodDetails1Builder builder) {
			ofNullable(getFrTm()).ifPresent(builder::setFrTm);
			ofNullable(getToTm()).ifPresent(builder::setToTm);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TimePeriodDetails1 _that = getType().cast(o);
		
			if (!Objects.equals(frTm, _that.getFrTm())) return false;
			if (!Objects.equals(toTm, _that.getToTm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (frTm != null ? frTm.hashCode() : 0);
			_result = 31 * _result + (toTm != null ? toTm.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TimePeriodDetails1 {" +
				"frTm=" + this.frTm + ", " +
				"toTm=" + this.toTm +
			'}';
		}
	}

	/*********************** Builder Implementation of TimePeriodDetails1  ***********************/
	class TimePeriodDetails1BuilderImpl implements TimePeriodDetails1.TimePeriodDetails1Builder {
	
		protected LocalTime frTm;
		protected LocalTime toTm;
		
		@Override
		@RosettaAttribute("frTm")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("frTm")
		public LocalTime getFrTm() {
			return frTm;
		}
		
		@Override
		@RosettaAttribute("toTm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("toTm")
		public LocalTime getToTm() {
			return toTm;
		}
		
		@RosettaAttribute("frTm")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("frTm")
		@Override
		public TimePeriodDetails1.TimePeriodDetails1Builder setFrTm(LocalTime _frTm) {
			this.frTm = _frTm == null ? null : _frTm;
			return this;
		}
		
		@RosettaAttribute("toTm")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("toTm")
		@Override
		public TimePeriodDetails1.TimePeriodDetails1Builder setToTm(LocalTime _toTm) {
			this.toTm = _toTm == null ? null : _toTm;
			return this;
		}
		
		@Override
		public TimePeriodDetails1 build() {
			return new TimePeriodDetails1.TimePeriodDetails1Impl(this);
		}
		
		@Override
		public TimePeriodDetails1.TimePeriodDetails1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TimePeriodDetails1.TimePeriodDetails1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFrTm()!=null) return true;
			if (getToTm()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TimePeriodDetails1.TimePeriodDetails1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TimePeriodDetails1.TimePeriodDetails1Builder o = (TimePeriodDetails1.TimePeriodDetails1Builder) other;
			
			
			merger.mergeBasic(getFrTm(), o.getFrTm(), this::setFrTm);
			merger.mergeBasic(getToTm(), o.getToTm(), this::setToTm);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TimePeriodDetails1 _that = getType().cast(o);
		
			if (!Objects.equals(frTm, _that.getFrTm())) return false;
			if (!Objects.equals(toTm, _that.getToTm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (frTm != null ? frTm.hashCode() : 0);
			_result = 31 * _result + (toTm != null ? toTm.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TimePeriodDetails1Builder {" +
				"frTm=" + this.frTm + ", " +
				"toTm=" + this.toTm +
			'}';
		}
	}
}

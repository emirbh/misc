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
import iso20022.auth030.hkma.tr.meta.ExerciseDate1Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Choice between a known exercise date and a pending date.
 * @version ${project.version}
 */
@RosettaDataType(value="ExerciseDate1Choice__1", builder=ExerciseDate1Choice__1.ExerciseDate1Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="ExerciseDate1Choice__1", model="iso20022", builder=ExerciseDate1Choice__1.ExerciseDate1Choice__1BuilderImpl.class, version="${project.version}")
public interface ExerciseDate1Choice__1 extends RosettaModelObject {

	ExerciseDate1Choice__1Meta metaData = new ExerciseDate1Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the earliest unadjusted date during the exercise period on which an option can be exercised.   Usage : For European style options, the first possible exercise date is the same as the ExpirationDate.  For American style options, the first possible exercise date is the same as the ExecutionTimeStamp.  For Knock-in options, the first exercise date is reported when available.
	 */
	Date getFrstExrcDt();

	/*********************** Build Methods  ***********************/
	ExerciseDate1Choice__1 build();
	
	ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder toBuilder();
	
	static ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder builder() {
		return new ExerciseDate1Choice__1.ExerciseDate1Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExerciseDate1Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExerciseDate1Choice__1> getType() {
		return ExerciseDate1Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("frstExrcDt"), Date.class, getFrstExrcDt(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExerciseDate1Choice__1Builder extends ExerciseDate1Choice__1, RosettaModelObjectBuilder {
		ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder setFrstExrcDt(Date frstExrcDt);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("frstExrcDt"), Date.class, getFrstExrcDt(), this);
		}
		

		ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of ExerciseDate1Choice__1  ***********************/
	class ExerciseDate1Choice__1Impl implements ExerciseDate1Choice__1 {
		private final Date frstExrcDt;
		
		protected ExerciseDate1Choice__1Impl(ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder builder) {
			this.frstExrcDt = builder.getFrstExrcDt();
		}
		
		@Override
		@RosettaAttribute("frstExrcDt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("frstExrcDt")
		public Date getFrstExrcDt() {
			return frstExrcDt;
		}
		
		@Override
		public ExerciseDate1Choice__1 build() {
			return this;
		}
		
		@Override
		public ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder toBuilder() {
			ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder builder) {
			ofNullable(getFrstExrcDt()).ifPresent(builder::setFrstExrcDt);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseDate1Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(frstExrcDt, _that.getFrstExrcDt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (frstExrcDt != null ? frstExrcDt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseDate1Choice__1 {" +
				"frstExrcDt=" + this.frstExrcDt +
			'}';
		}
	}

	/*********************** Builder Implementation of ExerciseDate1Choice__1  ***********************/
	class ExerciseDate1Choice__1BuilderImpl implements ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder {
	
		protected Date frstExrcDt;
		
		@Override
		@RosettaAttribute("frstExrcDt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("frstExrcDt")
		public Date getFrstExrcDt() {
			return frstExrcDt;
		}
		
		@RosettaAttribute("frstExrcDt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("frstExrcDt")
		@Override
		public ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder setFrstExrcDt(Date _frstExrcDt) {
			this.frstExrcDt = _frstExrcDt == null ? null : _frstExrcDt;
			return this;
		}
		
		@Override
		public ExerciseDate1Choice__1 build() {
			return new ExerciseDate1Choice__1.ExerciseDate1Choice__1Impl(this);
		}
		
		@Override
		public ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFrstExrcDt()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder o = (ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder) other;
			
			
			merger.mergeBasic(getFrstExrcDt(), o.getFrstExrcDt(), this::setFrstExrcDt);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseDate1Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(frstExrcDt, _that.getFrstExrcDt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (frstExrcDt != null ? frstExrcDt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseDate1Choice__1Builder {" +
				"frstExrcDt=" + this.frstExrcDt +
			'}';
		}
	}
}

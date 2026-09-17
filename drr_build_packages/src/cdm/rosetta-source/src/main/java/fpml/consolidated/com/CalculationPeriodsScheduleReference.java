package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.CalculationPeriodsScheduleReferenceMeta;
import fpml.consolidated.shared.Reference;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A pointer style reference to a calculation periods schedule defined elsewhere - note that this schedule consists of a parameterised schedule in a calculationPeriodsSchedule container.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A pointer style reference to a calculation periods schedule defined elsewhere - note that this schedule consists of a parameterised schedule in a calculationPeriodsSchedule container.
 *
 */
@RosettaDataType(value="CalculationPeriodsScheduleReference", builder=CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CalculationPeriodsScheduleReference", model="fpml", builder=CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilderImpl.class, version="2.1.1")
public interface CalculationPeriodsScheduleReference extends Reference {

	CalculationPeriodsScheduleReferenceMeta metaData = new CalculationPeriodsScheduleReferenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getHref();

	/*********************** Build Methods  ***********************/
	CalculationPeriodsScheduleReference build();
	
	CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder toBuilder();
	
	static CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder builder() {
		return new CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculationPeriodsScheduleReference> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CalculationPeriodsScheduleReference> getType() {
		return CalculationPeriodsScheduleReference.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationPeriodsScheduleReferenceBuilder extends CalculationPeriodsScheduleReference, Reference.ReferenceBuilder {
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of CalculationPeriodsScheduleReference  ***********************/
	class CalculationPeriodsScheduleReferenceImpl extends Reference.ReferenceImpl implements CalculationPeriodsScheduleReference {
		private final String href;
		
		protected CalculationPeriodsScheduleReferenceImpl(CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public CalculationPeriodsScheduleReference build() {
			return this;
		}
		
		@Override
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder toBuilder() {
			CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CalculationPeriodsScheduleReference _that = getType().cast(o);
		
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationPeriodsScheduleReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CalculationPeriodsScheduleReference  ***********************/
	class CalculationPeriodsScheduleReferenceBuilderImpl extends Reference.ReferenceBuilderImpl implements CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder {
	
		protected String href;
		
		@Override
		@RosettaAttribute("href")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("href")
		public String getHref() {
			return href;
		}
		
		@RosettaAttribute("href")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("href")
		@Override
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder setHref(String _href) {
			this.href = _href == null ? null : _href;
			return this;
		}
		
		@Override
		public CalculationPeriodsScheduleReference build() {
			return new CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceImpl(this);
		}
		
		@Override
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getHref()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder o = (CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CalculationPeriodsScheduleReference _that = getType().cast(o);
		
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationPeriodsScheduleReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}

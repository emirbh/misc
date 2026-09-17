package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.BusinessDayAdjustmentsReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Reference to a business day adjustments structure.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Reference to a business day adjustments structure.
 *
 */
@RosettaDataType(value="BusinessDayAdjustmentsReference", builder=BusinessDayAdjustmentsReference.BusinessDayAdjustmentsReferenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="BusinessDayAdjustmentsReference", model="fpml", builder=BusinessDayAdjustmentsReference.BusinessDayAdjustmentsReferenceBuilderImpl.class, version="2.1.1")
public interface BusinessDayAdjustmentsReference extends Reference {

	BusinessDayAdjustmentsReferenceMeta metaData = new BusinessDayAdjustmentsReferenceMeta();

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
	BusinessDayAdjustmentsReference build();
	
	BusinessDayAdjustmentsReference.BusinessDayAdjustmentsReferenceBuilder toBuilder();
	
	static BusinessDayAdjustmentsReference.BusinessDayAdjustmentsReferenceBuilder builder() {
		return new BusinessDayAdjustmentsReference.BusinessDayAdjustmentsReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BusinessDayAdjustmentsReference> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BusinessDayAdjustmentsReference> getType() {
		return BusinessDayAdjustmentsReference.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BusinessDayAdjustmentsReferenceBuilder extends BusinessDayAdjustmentsReference, Reference.ReferenceBuilder {
		BusinessDayAdjustmentsReference.BusinessDayAdjustmentsReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		BusinessDayAdjustmentsReference.BusinessDayAdjustmentsReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of BusinessDayAdjustmentsReference  ***********************/
	class BusinessDayAdjustmentsReferenceImpl extends Reference.ReferenceImpl implements BusinessDayAdjustmentsReference {
		private final String href;
		
		protected BusinessDayAdjustmentsReferenceImpl(BusinessDayAdjustmentsReference.BusinessDayAdjustmentsReferenceBuilder builder) {
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
		public BusinessDayAdjustmentsReference build() {
			return this;
		}
		
		@Override
		public BusinessDayAdjustmentsReference.BusinessDayAdjustmentsReferenceBuilder toBuilder() {
			BusinessDayAdjustmentsReference.BusinessDayAdjustmentsReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessDayAdjustmentsReference.BusinessDayAdjustmentsReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BusinessDayAdjustmentsReference _that = getType().cast(o);
		
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
			return "BusinessDayAdjustmentsReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of BusinessDayAdjustmentsReference  ***********************/
	class BusinessDayAdjustmentsReferenceBuilderImpl extends Reference.ReferenceBuilderImpl implements BusinessDayAdjustmentsReference.BusinessDayAdjustmentsReferenceBuilder {
	
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
		public BusinessDayAdjustmentsReference.BusinessDayAdjustmentsReferenceBuilder setHref(String _href) {
			this.href = _href == null ? null : _href;
			return this;
		}
		
		@Override
		public BusinessDayAdjustmentsReference build() {
			return new BusinessDayAdjustmentsReference.BusinessDayAdjustmentsReferenceImpl(this);
		}
		
		@Override
		public BusinessDayAdjustmentsReference.BusinessDayAdjustmentsReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessDayAdjustmentsReference.BusinessDayAdjustmentsReferenceBuilder prune() {
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
		public BusinessDayAdjustmentsReference.BusinessDayAdjustmentsReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			BusinessDayAdjustmentsReference.BusinessDayAdjustmentsReferenceBuilder o = (BusinessDayAdjustmentsReference.BusinessDayAdjustmentsReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BusinessDayAdjustmentsReference _that = getType().cast(o);
		
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
			return "BusinessDayAdjustmentsReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}

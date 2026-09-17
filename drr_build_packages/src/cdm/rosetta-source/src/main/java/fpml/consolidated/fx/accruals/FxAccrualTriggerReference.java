package fpml.consolidated.fx.accruals;

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
import fpml.consolidated.fx.accruals.meta.FxAccrualTriggerReferenceMeta;
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
 * Provision Reference to a trigger structure in FxAccrualDigitalOption product.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Reference to a trigger structure in FxAccrualDigitalOption product.
 *
 */
@RosettaDataType(value="FxAccrualTriggerReference", builder=FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxAccrualTriggerReference", model="fpml", builder=FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilderImpl.class, version="2.1.1")
public interface FxAccrualTriggerReference extends Reference {

	FxAccrualTriggerReferenceMeta metaData = new FxAccrualTriggerReferenceMeta();

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
	FxAccrualTriggerReference build();
	
	FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder toBuilder();
	
	static FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder builder() {
		return new FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualTriggerReference> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxAccrualTriggerReference> getType() {
		return FxAccrualTriggerReference.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualTriggerReferenceBuilder extends FxAccrualTriggerReference, Reference.ReferenceBuilder {
		FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualTriggerReference  ***********************/
	class FxAccrualTriggerReferenceImpl extends Reference.ReferenceImpl implements FxAccrualTriggerReference {
		private final String href;
		
		protected FxAccrualTriggerReferenceImpl(FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder builder) {
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
		public FxAccrualTriggerReference build() {
			return this;
		}
		
		@Override
		public FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder toBuilder() {
			FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualTriggerReference _that = getType().cast(o);
		
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
			return "FxAccrualTriggerReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAccrualTriggerReference  ***********************/
	class FxAccrualTriggerReferenceBuilderImpl extends Reference.ReferenceBuilderImpl implements FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder {
	
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
		public FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder setHref(String _href) {
			this.href = _href == null ? null : _href;
			return this;
		}
		
		@Override
		public FxAccrualTriggerReference build() {
			return new FxAccrualTriggerReference.FxAccrualTriggerReferenceImpl(this);
		}
		
		@Override
		public FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder prune() {
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
		public FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder o = (FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualTriggerReference _that = getType().cast(o);
		
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
			return "FxAccrualTriggerReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}

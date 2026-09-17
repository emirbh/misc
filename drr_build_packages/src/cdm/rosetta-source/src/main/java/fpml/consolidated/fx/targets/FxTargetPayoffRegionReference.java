package fpml.consolidated.fx.targets;

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
import fpml.consolidated.fx.targets.meta.FxTargetPayoffRegionReferenceMeta;
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
 * Provision Reference to a FX Target Payoff Region.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Reference to a FX Target Payoff Region.
 *
 */
@RosettaDataType(value="FxTargetPayoffRegionReference", builder=FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxTargetPayoffRegionReference", model="fpml", builder=FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilderImpl.class, version="2.1.1")
public interface FxTargetPayoffRegionReference extends Reference {

	FxTargetPayoffRegionReferenceMeta metaData = new FxTargetPayoffRegionReferenceMeta();

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
	FxTargetPayoffRegionReference build();
	
	FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder toBuilder();
	
	static FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder builder() {
		return new FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetPayoffRegionReference> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxTargetPayoffRegionReference> getType() {
		return FxTargetPayoffRegionReference.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetPayoffRegionReferenceBuilder extends FxTargetPayoffRegionReference, Reference.ReferenceBuilder {
		FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetPayoffRegionReference  ***********************/
	class FxTargetPayoffRegionReferenceImpl extends Reference.ReferenceImpl implements FxTargetPayoffRegionReference {
		private final String href;
		
		protected FxTargetPayoffRegionReferenceImpl(FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder builder) {
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
		public FxTargetPayoffRegionReference build() {
			return this;
		}
		
		@Override
		public FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder toBuilder() {
			FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxTargetPayoffRegionReference _that = getType().cast(o);
		
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
			return "FxTargetPayoffRegionReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxTargetPayoffRegionReference  ***********************/
	class FxTargetPayoffRegionReferenceBuilderImpl extends Reference.ReferenceBuilderImpl implements FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder {
	
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
		public FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder setHref(String _href) {
			this.href = _href == null ? null : _href;
			return this;
		}
		
		@Override
		public FxTargetPayoffRegionReference build() {
			return new FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceImpl(this);
		}
		
		@Override
		public FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder prune() {
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
		public FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder o = (FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxTargetPayoffRegionReference _that = getType().cast(o);
		
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
			return "FxTargetPayoffRegionReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}

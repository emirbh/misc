package fpml.consolidated.fx.targets;

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
import fpml.consolidated.fx.targets.meta.FxTargetPayoffRegionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
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
@RosettaDataType(value="FxTargetPayoffRegion", builder=FxTargetPayoffRegion.FxTargetPayoffRegionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxTargetPayoffRegion", model="fpml", builder=FxTargetPayoffRegion.FxTargetPayoffRegionBuilderImpl.class, version="2.1.1")
public interface FxTargetPayoffRegion extends RosettaModelObject {

	FxTargetPayoffRegionMeta metaData = new FxTargetPayoffRegionMeta();

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
	String getId();

	/*********************** Build Methods  ***********************/
	FxTargetPayoffRegion build();
	
	FxTargetPayoffRegion.FxTargetPayoffRegionBuilder toBuilder();
	
	static FxTargetPayoffRegion.FxTargetPayoffRegionBuilder builder() {
		return new FxTargetPayoffRegion.FxTargetPayoffRegionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetPayoffRegion> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxTargetPayoffRegion> getType() {
		return FxTargetPayoffRegion.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetPayoffRegionBuilder extends FxTargetPayoffRegion, RosettaModelObjectBuilder {
		FxTargetPayoffRegion.FxTargetPayoffRegionBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		FxTargetPayoffRegion.FxTargetPayoffRegionBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetPayoffRegion  ***********************/
	class FxTargetPayoffRegionImpl implements FxTargetPayoffRegion {
		private final String id;
		
		protected FxTargetPayoffRegionImpl(FxTargetPayoffRegion.FxTargetPayoffRegionBuilder builder) {
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public FxTargetPayoffRegion build() {
			return this;
		}
		
		@Override
		public FxTargetPayoffRegion.FxTargetPayoffRegionBuilder toBuilder() {
			FxTargetPayoffRegion.FxTargetPayoffRegionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetPayoffRegion.FxTargetPayoffRegionBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetPayoffRegion _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetPayoffRegion {" +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTargetPayoffRegion  ***********************/
	class FxTargetPayoffRegionBuilderImpl implements FxTargetPayoffRegion.FxTargetPayoffRegionBuilder {
	
		protected String id;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxTargetPayoffRegion.FxTargetPayoffRegionBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public FxTargetPayoffRegion build() {
			return new FxTargetPayoffRegion.FxTargetPayoffRegionImpl(this);
		}
		
		@Override
		public FxTargetPayoffRegion.FxTargetPayoffRegionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetPayoffRegion.FxTargetPayoffRegionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetPayoffRegion.FxTargetPayoffRegionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTargetPayoffRegion.FxTargetPayoffRegionBuilder o = (FxTargetPayoffRegion.FxTargetPayoffRegionBuilder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetPayoffRegion _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetPayoffRegionBuilder {" +
				"id=" + this.id +
			'}';
		}
	}
}

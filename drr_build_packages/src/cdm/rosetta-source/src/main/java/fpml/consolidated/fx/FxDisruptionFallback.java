package fpml.consolidated.fx;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.fx.meta.FxDisruptionFallbackMeta;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The base class for all disruption fallbacks
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The base class for all disruption fallbacks
 *
 */
@RosettaDataType(value="FxDisruptionFallback", builder=FxDisruptionFallback.FxDisruptionFallbackBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxDisruptionFallback", model="fpml", builder=FxDisruptionFallback.FxDisruptionFallbackBuilderImpl.class, version="2.1.1")
public interface FxDisruptionFallback extends RosettaModelObject {

	FxDisruptionFallbackMeta metaData = new FxDisruptionFallbackMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FxDisruptionFallback build();
	
	FxDisruptionFallback.FxDisruptionFallbackBuilder toBuilder();
	
	static FxDisruptionFallback.FxDisruptionFallbackBuilder builder() {
		return new FxDisruptionFallback.FxDisruptionFallbackBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxDisruptionFallback> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxDisruptionFallback> getType() {
		return FxDisruptionFallback.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxDisruptionFallbackBuilder extends FxDisruptionFallback, RosettaModelObjectBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		FxDisruptionFallback.FxDisruptionFallbackBuilder prune();
	}

	/*********************** Immutable Implementation of FxDisruptionFallback  ***********************/
	class FxDisruptionFallbackImpl implements FxDisruptionFallback {
		
		protected FxDisruptionFallbackImpl(FxDisruptionFallback.FxDisruptionFallbackBuilder builder) {
		}
		
		@Override
		public FxDisruptionFallback build() {
			return this;
		}
		
		@Override
		public FxDisruptionFallback.FxDisruptionFallbackBuilder toBuilder() {
			FxDisruptionFallback.FxDisruptionFallbackBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxDisruptionFallback.FxDisruptionFallbackBuilder builder) {
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDisruptionFallback {" +
			'}';
		}
	}

	/*********************** Builder Implementation of FxDisruptionFallback  ***********************/
	class FxDisruptionFallbackBuilderImpl implements FxDisruptionFallback.FxDisruptionFallbackBuilder {
	
		
		@Override
		public FxDisruptionFallback build() {
			return new FxDisruptionFallback.FxDisruptionFallbackImpl(this);
		}
		
		@Override
		public FxDisruptionFallback.FxDisruptionFallbackBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDisruptionFallback.FxDisruptionFallbackBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDisruptionFallback.FxDisruptionFallbackBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxDisruptionFallback.FxDisruptionFallbackBuilder o = (FxDisruptionFallback.FxDisruptionFallbackBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDisruptionFallbackBuilder {" +
			'}';
		}
	}
}

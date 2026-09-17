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
import fpml.consolidated.fx.meta.NoFaultTerminationMeta;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Indicates that the event may cause the transaction to terminate if all applicable provisions have been met.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Indicates that the event may cause the transaction to terminate if all applicable provisions have been met.
 *
 */
@RosettaDataType(value="NoFaultTermination", builder=NoFaultTermination.NoFaultTerminationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="NoFaultTermination", model="fpml", builder=NoFaultTermination.NoFaultTerminationBuilderImpl.class, version="2.1.1")
public interface NoFaultTermination extends FxDisruptionFallback {

	NoFaultTerminationMeta metaData = new NoFaultTerminationMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	NoFaultTermination build();
	
	NoFaultTermination.NoFaultTerminationBuilder toBuilder();
	
	static NoFaultTermination.NoFaultTerminationBuilder builder() {
		return new NoFaultTermination.NoFaultTerminationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NoFaultTermination> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NoFaultTermination> getType() {
		return NoFaultTermination.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface NoFaultTerminationBuilder extends NoFaultTermination, FxDisruptionFallback.FxDisruptionFallbackBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		NoFaultTermination.NoFaultTerminationBuilder prune();
	}

	/*********************** Immutable Implementation of NoFaultTermination  ***********************/
	class NoFaultTerminationImpl extends FxDisruptionFallback.FxDisruptionFallbackImpl implements NoFaultTermination {
		
		protected NoFaultTerminationImpl(NoFaultTermination.NoFaultTerminationBuilder builder) {
			super(builder);
		}
		
		@Override
		public NoFaultTermination build() {
			return this;
		}
		
		@Override
		public NoFaultTermination.NoFaultTerminationBuilder toBuilder() {
			NoFaultTermination.NoFaultTerminationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NoFaultTermination.NoFaultTerminationBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "NoFaultTermination {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NoFaultTermination  ***********************/
	class NoFaultTerminationBuilderImpl extends FxDisruptionFallback.FxDisruptionFallbackBuilderImpl implements NoFaultTermination.NoFaultTerminationBuilder {
	
		
		@Override
		public NoFaultTermination build() {
			return new NoFaultTermination.NoFaultTerminationImpl(this);
		}
		
		@Override
		public NoFaultTermination.NoFaultTerminationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoFaultTermination.NoFaultTerminationBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoFaultTermination.NoFaultTerminationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			NoFaultTermination.NoFaultTerminationBuilder o = (NoFaultTermination.NoFaultTerminationBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "NoFaultTerminationBuilder {" +
			'}' + " " + super.toString();
		}
	}
}

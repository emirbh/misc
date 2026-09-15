package fpml.consolidated.recordkeeping.processes;

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
import fpml.consolidated.recordkeeping.processes.meta.RegulatoryClassificationMeta;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). The base type which all regulatory classification types extend.
 *
 */
@RosettaDataType(value="RegulatoryClassification", builder=RegulatoryClassification.RegulatoryClassificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryClassification", model="fpml", builder=RegulatoryClassification.RegulatoryClassificationBuilderImpl.class, version="2.1.1")
public interface RegulatoryClassification extends RosettaModelObject {

	RegulatoryClassificationMeta metaData = new RegulatoryClassificationMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	RegulatoryClassification build();
	
	RegulatoryClassification.RegulatoryClassificationBuilder toBuilder();
	
	static RegulatoryClassification.RegulatoryClassificationBuilder builder() {
		return new RegulatoryClassification.RegulatoryClassificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryClassification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryClassification> getType() {
		return RegulatoryClassification.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryClassificationBuilder extends RegulatoryClassification, RosettaModelObjectBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		RegulatoryClassification.RegulatoryClassificationBuilder prune();
	}

	/*********************** Immutable Implementation of RegulatoryClassification  ***********************/
	class RegulatoryClassificationImpl implements RegulatoryClassification {
		
		protected RegulatoryClassificationImpl(RegulatoryClassification.RegulatoryClassificationBuilder builder) {
		}
		
		@Override
		public RegulatoryClassification build() {
			return this;
		}
		
		@Override
		public RegulatoryClassification.RegulatoryClassificationBuilder toBuilder() {
			RegulatoryClassification.RegulatoryClassificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryClassification.RegulatoryClassificationBuilder builder) {
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
			return "RegulatoryClassification {" +
			'}';
		}
	}

	/*********************** Builder Implementation of RegulatoryClassification  ***********************/
	class RegulatoryClassificationBuilderImpl implements RegulatoryClassification.RegulatoryClassificationBuilder {
	
		
		@Override
		public RegulatoryClassification build() {
			return new RegulatoryClassification.RegulatoryClassificationImpl(this);
		}
		
		@Override
		public RegulatoryClassification.RegulatoryClassificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryClassification.RegulatoryClassificationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryClassification.RegulatoryClassificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RegulatoryClassification.RegulatoryClassificationBuilder o = (RegulatoryClassification.RegulatoryClassificationBuilder) other;
			
			
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
			return "RegulatoryClassificationBuilder {" +
			'}';
		}
	}
}

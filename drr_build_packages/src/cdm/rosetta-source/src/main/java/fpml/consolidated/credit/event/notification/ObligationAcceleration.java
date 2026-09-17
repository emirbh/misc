package fpml.consolidated.credit.event.notification;

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
import fpml.consolidated.credit.event.notification.meta.ObligationAccelerationMeta;


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
@RosettaDataType(value="ObligationAcceleration", builder=ObligationAcceleration.ObligationAccelerationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ObligationAcceleration", model="fpml", builder=ObligationAcceleration.ObligationAccelerationBuilderImpl.class, version="2.1.1")
public interface ObligationAcceleration extends ObligationAccelerationEvent {

	ObligationAccelerationMeta metaData = new ObligationAccelerationMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	ObligationAcceleration build();
	
	ObligationAcceleration.ObligationAccelerationBuilder toBuilder();
	
	static ObligationAcceleration.ObligationAccelerationBuilder builder() {
		return new ObligationAcceleration.ObligationAccelerationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ObligationAcceleration> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ObligationAcceleration> getType() {
		return ObligationAcceleration.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface ObligationAccelerationBuilder extends ObligationAcceleration, ObligationAccelerationEvent.ObligationAccelerationEventBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		ObligationAcceleration.ObligationAccelerationBuilder prune();
	}

	/*********************** Immutable Implementation of ObligationAcceleration  ***********************/
	class ObligationAccelerationImpl extends ObligationAccelerationEvent.ObligationAccelerationEventImpl implements ObligationAcceleration {
		
		protected ObligationAccelerationImpl(ObligationAcceleration.ObligationAccelerationBuilder builder) {
			super(builder);
		}
		
		@Override
		public ObligationAcceleration build() {
			return this;
		}
		
		@Override
		public ObligationAcceleration.ObligationAccelerationBuilder toBuilder() {
			ObligationAcceleration.ObligationAccelerationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObligationAcceleration.ObligationAccelerationBuilder builder) {
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
			return "ObligationAcceleration {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ObligationAcceleration  ***********************/
	class ObligationAccelerationBuilderImpl extends ObligationAccelerationEvent.ObligationAccelerationEventBuilderImpl implements ObligationAcceleration.ObligationAccelerationBuilder {
	
		
		@Override
		public ObligationAcceleration build() {
			return new ObligationAcceleration.ObligationAccelerationImpl(this);
		}
		
		@Override
		public ObligationAcceleration.ObligationAccelerationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObligationAcceleration.ObligationAccelerationBuilder prune() {
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
		public ObligationAcceleration.ObligationAccelerationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ObligationAcceleration.ObligationAccelerationBuilder o = (ObligationAcceleration.ObligationAccelerationBuilder) other;
			
			
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
			return "ObligationAccelerationBuilder {" +
			'}' + " " + super.toString();
		}
	}
}

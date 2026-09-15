package fpml.consolidated.accumulator;

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
import fpml.consolidated.accumulator.meta.SharesPerDayMeta;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="SharesPerDay", builder=SharesPerDay.SharesPerDayBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SharesPerDay", model="fpml", builder=SharesPerDay.SharesPerDayBuilderImpl.class, version="2.1.1")
public interface SharesPerDay extends RosettaModelObject {

	SharesPerDayMeta metaData = new SharesPerDayMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	SharesPerDay build();
	
	SharesPerDay.SharesPerDayBuilder toBuilder();
	
	static SharesPerDay.SharesPerDayBuilder builder() {
		return new SharesPerDay.SharesPerDayBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SharesPerDay> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SharesPerDay> getType() {
		return SharesPerDay.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface SharesPerDayBuilder extends SharesPerDay, RosettaModelObjectBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		SharesPerDay.SharesPerDayBuilder prune();
	}

	/*********************** Immutable Implementation of SharesPerDay  ***********************/
	class SharesPerDayImpl implements SharesPerDay {
		
		protected SharesPerDayImpl(SharesPerDay.SharesPerDayBuilder builder) {
		}
		
		@Override
		public SharesPerDay build() {
			return this;
		}
		
		@Override
		public SharesPerDay.SharesPerDayBuilder toBuilder() {
			SharesPerDay.SharesPerDayBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SharesPerDay.SharesPerDayBuilder builder) {
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
			return "SharesPerDay {" +
			'}';
		}
	}

	/*********************** Builder Implementation of SharesPerDay  ***********************/
	class SharesPerDayBuilderImpl implements SharesPerDay.SharesPerDayBuilder {
	
		
		@Override
		public SharesPerDay build() {
			return new SharesPerDay.SharesPerDayImpl(this);
		}
		
		@Override
		public SharesPerDay.SharesPerDayBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SharesPerDay.SharesPerDayBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SharesPerDay.SharesPerDayBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SharesPerDay.SharesPerDayBuilder o = (SharesPerDay.SharesPerDayBuilder) other;
			
			
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
			return "SharesPerDayBuilder {" +
			'}';
		}
	}
}

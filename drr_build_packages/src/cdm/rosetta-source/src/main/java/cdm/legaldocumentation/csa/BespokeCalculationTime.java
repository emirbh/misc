package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.BespokeCalculationTimeMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify additional Calculation Time terms for the purposes of Initial Margin.
 * @version 6.23.0
 */
@RosettaDataType(value="BespokeCalculationTime", builder=BespokeCalculationTime.BespokeCalculationTimeBuilderImpl.class, version="6.23.0")
@RuneDataType(value="BespokeCalculationTime", model="cdm", builder=BespokeCalculationTime.BespokeCalculationTimeBuilderImpl.class, version="6.23.0")
public interface BespokeCalculationTime extends RosettaModelObject {

	BespokeCalculationTimeMeta metaData = new BespokeCalculationTimeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * If set to True, the Calculation Time for Initial Margin is the time as of which the Calculation Agent (IM) computes its end of day valuations of derivatives transactions.
	 */
	Boolean getAsCalculationAgent();
	/**
	 * Additional Terms applicable to Calculation Time for Initial Margin.
	 */
	String getBespokeCalculationTimeTerms();

	/*********************** Build Methods  ***********************/
	BespokeCalculationTime build();
	
	BespokeCalculationTime.BespokeCalculationTimeBuilder toBuilder();
	
	static BespokeCalculationTime.BespokeCalculationTimeBuilder builder() {
		return new BespokeCalculationTime.BespokeCalculationTimeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BespokeCalculationTime> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BespokeCalculationTime> getType() {
		return BespokeCalculationTime.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("asCalculationAgent"), Boolean.class, getAsCalculationAgent(), this);
		processor.processBasic(path.newSubPath("bespokeCalculationTimeTerms"), String.class, getBespokeCalculationTimeTerms(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BespokeCalculationTimeBuilder extends BespokeCalculationTime, RosettaModelObjectBuilder {
		BespokeCalculationTime.BespokeCalculationTimeBuilder setAsCalculationAgent(Boolean asCalculationAgent);
		BespokeCalculationTime.BespokeCalculationTimeBuilder setBespokeCalculationTimeTerms(String bespokeCalculationTimeTerms);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("asCalculationAgent"), Boolean.class, getAsCalculationAgent(), this);
			processor.processBasic(path.newSubPath("bespokeCalculationTimeTerms"), String.class, getBespokeCalculationTimeTerms(), this);
		}
		

		BespokeCalculationTime.BespokeCalculationTimeBuilder prune();
	}

	/*********************** Immutable Implementation of BespokeCalculationTime  ***********************/
	class BespokeCalculationTimeImpl implements BespokeCalculationTime {
		private final Boolean asCalculationAgent;
		private final String bespokeCalculationTimeTerms;
		
		protected BespokeCalculationTimeImpl(BespokeCalculationTime.BespokeCalculationTimeBuilder builder) {
			this.asCalculationAgent = builder.getAsCalculationAgent();
			this.bespokeCalculationTimeTerms = builder.getBespokeCalculationTimeTerms();
		}
		
		@Override
		@RosettaAttribute("asCalculationAgent")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("asCalculationAgent")
		public Boolean getAsCalculationAgent() {
			return asCalculationAgent;
		}
		
		@Override
		@RosettaAttribute("bespokeCalculationTimeTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bespokeCalculationTimeTerms")
		public String getBespokeCalculationTimeTerms() {
			return bespokeCalculationTimeTerms;
		}
		
		@Override
		public BespokeCalculationTime build() {
			return this;
		}
		
		@Override
		public BespokeCalculationTime.BespokeCalculationTimeBuilder toBuilder() {
			BespokeCalculationTime.BespokeCalculationTimeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BespokeCalculationTime.BespokeCalculationTimeBuilder builder) {
			ofNullable(getAsCalculationAgent()).ifPresent(builder::setAsCalculationAgent);
			ofNullable(getBespokeCalculationTimeTerms()).ifPresent(builder::setBespokeCalculationTimeTerms);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BespokeCalculationTime _that = getType().cast(o);
		
			if (!Objects.equals(asCalculationAgent, _that.getAsCalculationAgent())) return false;
			if (!Objects.equals(bespokeCalculationTimeTerms, _that.getBespokeCalculationTimeTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asCalculationAgent != null ? asCalculationAgent.hashCode() : 0);
			_result = 31 * _result + (bespokeCalculationTimeTerms != null ? bespokeCalculationTimeTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BespokeCalculationTime {" +
				"asCalculationAgent=" + this.asCalculationAgent + ", " +
				"bespokeCalculationTimeTerms=" + this.bespokeCalculationTimeTerms +
			'}';
		}
	}

	/*********************** Builder Implementation of BespokeCalculationTime  ***********************/
	class BespokeCalculationTimeBuilderImpl implements BespokeCalculationTime.BespokeCalculationTimeBuilder {
	
		protected Boolean asCalculationAgent;
		protected String bespokeCalculationTimeTerms;
		
		@Override
		@RosettaAttribute("asCalculationAgent")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("asCalculationAgent")
		public Boolean getAsCalculationAgent() {
			return asCalculationAgent;
		}
		
		@Override
		@RosettaAttribute("bespokeCalculationTimeTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bespokeCalculationTimeTerms")
		public String getBespokeCalculationTimeTerms() {
			return bespokeCalculationTimeTerms;
		}
		
		@RosettaAttribute("asCalculationAgent")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("asCalculationAgent")
		@Override
		public BespokeCalculationTime.BespokeCalculationTimeBuilder setAsCalculationAgent(Boolean _asCalculationAgent) {
			this.asCalculationAgent = _asCalculationAgent == null ? null : _asCalculationAgent;
			return this;
		}
		
		@RosettaAttribute("bespokeCalculationTimeTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bespokeCalculationTimeTerms")
		@Override
		public BespokeCalculationTime.BespokeCalculationTimeBuilder setBespokeCalculationTimeTerms(String _bespokeCalculationTimeTerms) {
			this.bespokeCalculationTimeTerms = _bespokeCalculationTimeTerms == null ? null : _bespokeCalculationTimeTerms;
			return this;
		}
		
		@Override
		public BespokeCalculationTime build() {
			return new BespokeCalculationTime.BespokeCalculationTimeImpl(this);
		}
		
		@Override
		public BespokeCalculationTime.BespokeCalculationTimeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BespokeCalculationTime.BespokeCalculationTimeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAsCalculationAgent()!=null) return true;
			if (getBespokeCalculationTimeTerms()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BespokeCalculationTime.BespokeCalculationTimeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BespokeCalculationTime.BespokeCalculationTimeBuilder o = (BespokeCalculationTime.BespokeCalculationTimeBuilder) other;
			
			
			merger.mergeBasic(getAsCalculationAgent(), o.getAsCalculationAgent(), this::setAsCalculationAgent);
			merger.mergeBasic(getBespokeCalculationTimeTerms(), o.getBespokeCalculationTimeTerms(), this::setBespokeCalculationTimeTerms);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BespokeCalculationTime _that = getType().cast(o);
		
			if (!Objects.equals(asCalculationAgent, _that.getAsCalculationAgent())) return false;
			if (!Objects.equals(bespokeCalculationTimeTerms, _that.getBespokeCalculationTimeTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asCalculationAgent != null ? asCalculationAgent.hashCode() : 0);
			_result = 31 * _result + (bespokeCalculationTimeTerms != null ? bespokeCalculationTimeTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BespokeCalculationTimeBuilder {" +
				"asCalculationAgent=" + this.asCalculationAgent + ", " +
				"bespokeCalculationTimeTerms=" + this.bespokeCalculationTimeTerms +
			'}';
		}
	}
}

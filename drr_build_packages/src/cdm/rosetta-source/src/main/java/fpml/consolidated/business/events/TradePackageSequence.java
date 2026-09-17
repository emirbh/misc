package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.TradePackageSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

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
@RosettaDataType(value="TradePackageSequence", builder=TradePackageSequence.TradePackageSequenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TradePackageSequence", model="fpml", builder=TradePackageSequence.TradePackageSequenceBuilderImpl.class, version="2.1.1")
public interface TradePackageSequence extends RosettaModelObject {

	TradePackageSequenceMeta metaData = new TradePackageSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Information about a trade.
	 *
	 */
	TradeReferenceInformation getTradeReferenceInformation();

	/*********************** Build Methods  ***********************/
	TradePackageSequence build();
	
	TradePackageSequence.TradePackageSequenceBuilder toBuilder();
	
	static TradePackageSequence.TradePackageSequenceBuilder builder() {
		return new TradePackageSequence.TradePackageSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradePackageSequence> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradePackageSequence> getType() {
		return TradePackageSequence.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradeReferenceInformation"), processor, TradeReferenceInformation.class, getTradeReferenceInformation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradePackageSequenceBuilder extends TradePackageSequence, RosettaModelObjectBuilder {
		TradeReferenceInformation.TradeReferenceInformationBuilder getOrCreateTradeReferenceInformation();
		@Override
		TradeReferenceInformation.TradeReferenceInformationBuilder getTradeReferenceInformation();
		TradePackageSequence.TradePackageSequenceBuilder setTradeReferenceInformation(TradeReferenceInformation tradeReferenceInformation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradeReferenceInformation"), processor, TradeReferenceInformation.TradeReferenceInformationBuilder.class, getTradeReferenceInformation());
		}
		

		TradePackageSequence.TradePackageSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of TradePackageSequence  ***********************/
	class TradePackageSequenceImpl implements TradePackageSequence {
		private final TradeReferenceInformation tradeReferenceInformation;
		
		protected TradePackageSequenceImpl(TradePackageSequence.TradePackageSequenceBuilder builder) {
			this.tradeReferenceInformation = ofNullable(builder.getTradeReferenceInformation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeReferenceInformation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradeReferenceInformation")
		public TradeReferenceInformation getTradeReferenceInformation() {
			return tradeReferenceInformation;
		}
		
		@Override
		public TradePackageSequence build() {
			return this;
		}
		
		@Override
		public TradePackageSequence.TradePackageSequenceBuilder toBuilder() {
			TradePackageSequence.TradePackageSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradePackageSequence.TradePackageSequenceBuilder builder) {
			ofNullable(getTradeReferenceInformation()).ifPresent(builder::setTradeReferenceInformation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradePackageSequence _that = getType().cast(o);
		
			if (!Objects.equals(tradeReferenceInformation, _that.getTradeReferenceInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeReferenceInformation != null ? tradeReferenceInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradePackageSequence {" +
				"tradeReferenceInformation=" + this.tradeReferenceInformation +
			'}';
		}
	}

	/*********************** Builder Implementation of TradePackageSequence  ***********************/
	class TradePackageSequenceBuilderImpl implements TradePackageSequence.TradePackageSequenceBuilder {
	
		protected TradeReferenceInformation.TradeReferenceInformationBuilder tradeReferenceInformation;
		
		@Override
		@RosettaAttribute("tradeReferenceInformation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradeReferenceInformation")
		public TradeReferenceInformation.TradeReferenceInformationBuilder getTradeReferenceInformation() {
			return tradeReferenceInformation;
		}
		
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder getOrCreateTradeReferenceInformation() {
			TradeReferenceInformation.TradeReferenceInformationBuilder result;
			if (tradeReferenceInformation!=null) {
				result = tradeReferenceInformation;
			}
			else {
				result = tradeReferenceInformation = TradeReferenceInformation.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("tradeReferenceInformation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tradeReferenceInformation")
		@Override
		public TradePackageSequence.TradePackageSequenceBuilder setTradeReferenceInformation(TradeReferenceInformation _tradeReferenceInformation) {
			this.tradeReferenceInformation = _tradeReferenceInformation == null ? null : _tradeReferenceInformation.toBuilder();
			return this;
		}
		
		@Override
		public TradePackageSequence build() {
			return new TradePackageSequence.TradePackageSequenceImpl(this);
		}
		
		@Override
		public TradePackageSequence.TradePackageSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradePackageSequence.TradePackageSequenceBuilder prune() {
			if (tradeReferenceInformation!=null && !tradeReferenceInformation.prune().hasData()) tradeReferenceInformation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradeReferenceInformation()!=null && getTradeReferenceInformation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradePackageSequence.TradePackageSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradePackageSequence.TradePackageSequenceBuilder o = (TradePackageSequence.TradePackageSequenceBuilder) other;
			
			merger.mergeRosetta(getTradeReferenceInformation(), o.getTradeReferenceInformation(), this::setTradeReferenceInformation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradePackageSequence _that = getType().cast(o);
		
			if (!Objects.equals(tradeReferenceInformation, _that.getTradeReferenceInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeReferenceInformation != null ? tradeReferenceInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradePackageSequenceBuilder {" +
				"tradeReferenceInformation=" + this.tradeReferenceInformation +
			'}';
		}
	}
}

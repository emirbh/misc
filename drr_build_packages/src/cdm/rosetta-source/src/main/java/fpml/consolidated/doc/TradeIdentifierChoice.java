package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.TradeIdentifierChoiceMeta;
import fpml.consolidated.shared.TradeId;
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
@RosettaDataType(value="TradeIdentifierChoice", builder=TradeIdentifierChoice.TradeIdentifierChoiceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TradeIdentifierChoice", model="fpml", builder=TradeIdentifierChoice.TradeIdentifierChoiceBuilderImpl.class, version="2.1.1")
public interface TradeIdentifierChoice extends RosettaModelObject {

	TradeIdentifierChoiceMeta metaData = new TradeIdentifierChoiceMeta();

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
	TradeId getTradeId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A trade identifier accompanied by a version number. In regulatory reporting views, this should be avoided except for internal mnessaging.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A trade identifier accompanied by a version number. In regulatory reporting views, this should be avoided except for internal mnessaging.
	 *
	 */
	VersionedTradeId getVersionedTradeId();

	/*********************** Build Methods  ***********************/
	TradeIdentifierChoice build();
	
	TradeIdentifierChoice.TradeIdentifierChoiceBuilder toBuilder();
	
	static TradeIdentifierChoice.TradeIdentifierChoiceBuilder builder() {
		return new TradeIdentifierChoice.TradeIdentifierChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeIdentifierChoice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeIdentifierChoice> getType() {
		return TradeIdentifierChoice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradeId"), processor, TradeId.class, getTradeId());
		processRosetta(path.newSubPath("versionedTradeId"), processor, VersionedTradeId.class, getVersionedTradeId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeIdentifierChoiceBuilder extends TradeIdentifierChoice, RosettaModelObjectBuilder {
		TradeId.TradeIdBuilder getOrCreateTradeId();
		@Override
		TradeId.TradeIdBuilder getTradeId();
		VersionedTradeId.VersionedTradeIdBuilder getOrCreateVersionedTradeId();
		@Override
		VersionedTradeId.VersionedTradeIdBuilder getVersionedTradeId();
		TradeIdentifierChoice.TradeIdentifierChoiceBuilder setTradeId(TradeId tradeId);
		TradeIdentifierChoice.TradeIdentifierChoiceBuilder setVersionedTradeId(VersionedTradeId versionedTradeId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradeId"), processor, TradeId.TradeIdBuilder.class, getTradeId());
			processRosetta(path.newSubPath("versionedTradeId"), processor, VersionedTradeId.VersionedTradeIdBuilder.class, getVersionedTradeId());
		}
		

		TradeIdentifierChoice.TradeIdentifierChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of TradeIdentifierChoice  ***********************/
	class TradeIdentifierChoiceImpl implements TradeIdentifierChoice {
		private final TradeId tradeId;
		private final VersionedTradeId versionedTradeId;
		
		protected TradeIdentifierChoiceImpl(TradeIdentifierChoice.TradeIdentifierChoiceBuilder builder) {
			this.tradeId = ofNullable(builder.getTradeId()).map(f->f.build()).orElse(null);
			this.versionedTradeId = ofNullable(builder.getVersionedTradeId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeId")
		public TradeId getTradeId() {
			return tradeId;
		}
		
		@Override
		@RosettaAttribute("versionedTradeId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("versionedTradeId")
		public VersionedTradeId getVersionedTradeId() {
			return versionedTradeId;
		}
		
		@Override
		public TradeIdentifierChoice build() {
			return this;
		}
		
		@Override
		public TradeIdentifierChoice.TradeIdentifierChoiceBuilder toBuilder() {
			TradeIdentifierChoice.TradeIdentifierChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeIdentifierChoice.TradeIdentifierChoiceBuilder builder) {
			ofNullable(getTradeId()).ifPresent(builder::setTradeId);
			ofNullable(getVersionedTradeId()).ifPresent(builder::setVersionedTradeId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeIdentifierChoice _that = getType().cast(o);
		
			if (!Objects.equals(tradeId, _that.getTradeId())) return false;
			if (!Objects.equals(versionedTradeId, _that.getVersionedTradeId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeId != null ? tradeId.hashCode() : 0);
			_result = 31 * _result + (versionedTradeId != null ? versionedTradeId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeIdentifierChoice {" +
				"tradeId=" + this.tradeId + ", " +
				"versionedTradeId=" + this.versionedTradeId +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeIdentifierChoice  ***********************/
	class TradeIdentifierChoiceBuilderImpl implements TradeIdentifierChoice.TradeIdentifierChoiceBuilder {
	
		protected TradeId.TradeIdBuilder tradeId;
		protected VersionedTradeId.VersionedTradeIdBuilder versionedTradeId;
		
		@Override
		@RosettaAttribute("tradeId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeId")
		public TradeId.TradeIdBuilder getTradeId() {
			return tradeId;
		}
		
		@Override
		public TradeId.TradeIdBuilder getOrCreateTradeId() {
			TradeId.TradeIdBuilder result;
			if (tradeId!=null) {
				result = tradeId;
			}
			else {
				result = tradeId = TradeId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("versionedTradeId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("versionedTradeId")
		public VersionedTradeId.VersionedTradeIdBuilder getVersionedTradeId() {
			return versionedTradeId;
		}
		
		@Override
		public VersionedTradeId.VersionedTradeIdBuilder getOrCreateVersionedTradeId() {
			VersionedTradeId.VersionedTradeIdBuilder result;
			if (versionedTradeId!=null) {
				result = versionedTradeId;
			}
			else {
				result = versionedTradeId = VersionedTradeId.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("tradeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeId")
		@Override
		public TradeIdentifierChoice.TradeIdentifierChoiceBuilder setTradeId(TradeId _tradeId) {
			this.tradeId = _tradeId == null ? null : _tradeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("versionedTradeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("versionedTradeId")
		@Override
		public TradeIdentifierChoice.TradeIdentifierChoiceBuilder setVersionedTradeId(VersionedTradeId _versionedTradeId) {
			this.versionedTradeId = _versionedTradeId == null ? null : _versionedTradeId.toBuilder();
			return this;
		}
		
		@Override
		public TradeIdentifierChoice build() {
			return new TradeIdentifierChoice.TradeIdentifierChoiceImpl(this);
		}
		
		@Override
		public TradeIdentifierChoice.TradeIdentifierChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeIdentifierChoice.TradeIdentifierChoiceBuilder prune() {
			if (tradeId!=null && !tradeId.prune().hasData()) tradeId = null;
			if (versionedTradeId!=null && !versionedTradeId.prune().hasData()) versionedTradeId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradeId()!=null && getTradeId().hasData()) return true;
			if (getVersionedTradeId()!=null && getVersionedTradeId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeIdentifierChoice.TradeIdentifierChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeIdentifierChoice.TradeIdentifierChoiceBuilder o = (TradeIdentifierChoice.TradeIdentifierChoiceBuilder) other;
			
			merger.mergeRosetta(getTradeId(), o.getTradeId(), this::setTradeId);
			merger.mergeRosetta(getVersionedTradeId(), o.getVersionedTradeId(), this::setVersionedTradeId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeIdentifierChoice _that = getType().cast(o);
		
			if (!Objects.equals(tradeId, _that.getTradeId())) return false;
			if (!Objects.equals(versionedTradeId, _that.getVersionedTradeId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeId != null ? tradeId.hashCode() : 0);
			_result = 31 * _result + (versionedTradeId != null ? versionedTradeId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeIdentifierChoiceBuilder {" +
				"tradeId=" + this.tradeId + ", " +
				"versionedTradeId=" + this.versionedTradeId +
			'}';
		}
	}
}

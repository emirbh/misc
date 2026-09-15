package fpml.consolidated.business.events;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.consolidated.business.events.meta.CompressionActivityMeta;
import fpml.consolidated.doc.TradeIdentifier;
import fpml.consolidated.shared.TradeId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that shows how multiple trades have been combined into a result.
 *
 */
@RosettaDataType(value="CompressionActivity", builder=CompressionActivity.CompressionActivityBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CompressionActivity", model="fpml", builder=CompressionActivity.CompressionActivityBuilderImpl.class, version="2.1.1")
public interface CompressionActivity extends RosettaModelObject {

	CompressionActivityMeta metaData = new CompressionActivityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	CompressionType getCompressionType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	TradeIdentifier getReplacementTradeIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends TradeIdentifier> getOriginatingTradeIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	TradeId getReplacementTradeId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends TradeId> getOriginatingTradeId();

	/*********************** Build Methods  ***********************/
	CompressionActivity build();
	
	CompressionActivity.CompressionActivityBuilder toBuilder();
	
	static CompressionActivity.CompressionActivityBuilder builder() {
		return new CompressionActivity.CompressionActivityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CompressionActivity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CompressionActivity> getType() {
		return CompressionActivity.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("compressionType"), processor, CompressionType.class, getCompressionType());
		processRosetta(path.newSubPath("replacementTradeIdentifier"), processor, TradeIdentifier.class, getReplacementTradeIdentifier());
		processRosetta(path.newSubPath("originatingTradeIdentifier"), processor, TradeIdentifier.class, getOriginatingTradeIdentifier());
		processRosetta(path.newSubPath("replacementTradeId"), processor, TradeId.class, getReplacementTradeId());
		processRosetta(path.newSubPath("originatingTradeId"), processor, TradeId.class, getOriginatingTradeId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CompressionActivityBuilder extends CompressionActivity, RosettaModelObjectBuilder {
		CompressionType.CompressionTypeBuilder getOrCreateCompressionType();
		@Override
		CompressionType.CompressionTypeBuilder getCompressionType();
		TradeIdentifier.TradeIdentifierBuilder getOrCreateReplacementTradeIdentifier();
		@Override
		TradeIdentifier.TradeIdentifierBuilder getReplacementTradeIdentifier();
		TradeIdentifier.TradeIdentifierBuilder getOrCreateOriginatingTradeIdentifier(int index);
		@Override
		List<? extends TradeIdentifier.TradeIdentifierBuilder> getOriginatingTradeIdentifier();
		TradeId.TradeIdBuilder getOrCreateReplacementTradeId();
		@Override
		TradeId.TradeIdBuilder getReplacementTradeId();
		TradeId.TradeIdBuilder getOrCreateOriginatingTradeId(int index);
		@Override
		List<? extends TradeId.TradeIdBuilder> getOriginatingTradeId();
		CompressionActivity.CompressionActivityBuilder setCompressionType(CompressionType compressionType);
		CompressionActivity.CompressionActivityBuilder setReplacementTradeIdentifier(TradeIdentifier replacementTradeIdentifier);
		CompressionActivity.CompressionActivityBuilder addOriginatingTradeIdentifier(TradeIdentifier originatingTradeIdentifier);
		CompressionActivity.CompressionActivityBuilder addOriginatingTradeIdentifier(TradeIdentifier originatingTradeIdentifier, int idx);
		CompressionActivity.CompressionActivityBuilder addOriginatingTradeIdentifier(List<? extends TradeIdentifier> originatingTradeIdentifier);
		CompressionActivity.CompressionActivityBuilder setOriginatingTradeIdentifier(List<? extends TradeIdentifier> originatingTradeIdentifier);
		CompressionActivity.CompressionActivityBuilder setReplacementTradeId(TradeId replacementTradeId);
		CompressionActivity.CompressionActivityBuilder addOriginatingTradeId(TradeId originatingTradeId);
		CompressionActivity.CompressionActivityBuilder addOriginatingTradeId(TradeId originatingTradeId, int idx);
		CompressionActivity.CompressionActivityBuilder addOriginatingTradeId(List<? extends TradeId> originatingTradeId);
		CompressionActivity.CompressionActivityBuilder setOriginatingTradeId(List<? extends TradeId> originatingTradeId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("compressionType"), processor, CompressionType.CompressionTypeBuilder.class, getCompressionType());
			processRosetta(path.newSubPath("replacementTradeIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getReplacementTradeIdentifier());
			processRosetta(path.newSubPath("originatingTradeIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getOriginatingTradeIdentifier());
			processRosetta(path.newSubPath("replacementTradeId"), processor, TradeId.TradeIdBuilder.class, getReplacementTradeId());
			processRosetta(path.newSubPath("originatingTradeId"), processor, TradeId.TradeIdBuilder.class, getOriginatingTradeId());
		}
		

		CompressionActivity.CompressionActivityBuilder prune();
	}

	/*********************** Immutable Implementation of CompressionActivity  ***********************/
	class CompressionActivityImpl implements CompressionActivity {
		private final CompressionType compressionType;
		private final TradeIdentifier replacementTradeIdentifier;
		private final List<? extends TradeIdentifier> originatingTradeIdentifier;
		private final TradeId replacementTradeId;
		private final List<? extends TradeId> originatingTradeId;
		
		protected CompressionActivityImpl(CompressionActivity.CompressionActivityBuilder builder) {
			this.compressionType = ofNullable(builder.getCompressionType()).map(f->f.build()).orElse(null);
			this.replacementTradeIdentifier = ofNullable(builder.getReplacementTradeIdentifier()).map(f->f.build()).orElse(null);
			this.originatingTradeIdentifier = ofNullable(builder.getOriginatingTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.replacementTradeId = ofNullable(builder.getReplacementTradeId()).map(f->f.build()).orElse(null);
			this.originatingTradeId = ofNullable(builder.getOriginatingTradeId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("compressionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("compressionType")
		public CompressionType getCompressionType() {
			return compressionType;
		}
		
		@Override
		@RosettaAttribute("replacementTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("replacementTradeIdentifier")
		public TradeIdentifier getReplacementTradeIdentifier() {
			return replacementTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("originatingTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("originatingTradeIdentifier")
		public List<? extends TradeIdentifier> getOriginatingTradeIdentifier() {
			return originatingTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("replacementTradeId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("replacementTradeId")
		public TradeId getReplacementTradeId() {
			return replacementTradeId;
		}
		
		@Override
		@RosettaAttribute("originatingTradeId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("originatingTradeId")
		public List<? extends TradeId> getOriginatingTradeId() {
			return originatingTradeId;
		}
		
		@Override
		public CompressionActivity build() {
			return this;
		}
		
		@Override
		public CompressionActivity.CompressionActivityBuilder toBuilder() {
			CompressionActivity.CompressionActivityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CompressionActivity.CompressionActivityBuilder builder) {
			ofNullable(getCompressionType()).ifPresent(builder::setCompressionType);
			ofNullable(getReplacementTradeIdentifier()).ifPresent(builder::setReplacementTradeIdentifier);
			ofNullable(getOriginatingTradeIdentifier()).ifPresent(builder::setOriginatingTradeIdentifier);
			ofNullable(getReplacementTradeId()).ifPresent(builder::setReplacementTradeId);
			ofNullable(getOriginatingTradeId()).ifPresent(builder::setOriginatingTradeId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CompressionActivity _that = getType().cast(o);
		
			if (!Objects.equals(compressionType, _that.getCompressionType())) return false;
			if (!Objects.equals(replacementTradeIdentifier, _that.getReplacementTradeIdentifier())) return false;
			if (!ListEquals.listEquals(originatingTradeIdentifier, _that.getOriginatingTradeIdentifier())) return false;
			if (!Objects.equals(replacementTradeId, _that.getReplacementTradeId())) return false;
			if (!ListEquals.listEquals(originatingTradeId, _that.getOriginatingTradeId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (compressionType != null ? compressionType.hashCode() : 0);
			_result = 31 * _result + (replacementTradeIdentifier != null ? replacementTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (originatingTradeIdentifier != null ? originatingTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (replacementTradeId != null ? replacementTradeId.hashCode() : 0);
			_result = 31 * _result + (originatingTradeId != null ? originatingTradeId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CompressionActivity {" +
				"compressionType=" + this.compressionType + ", " +
				"replacementTradeIdentifier=" + this.replacementTradeIdentifier + ", " +
				"originatingTradeIdentifier=" + this.originatingTradeIdentifier + ", " +
				"replacementTradeId=" + this.replacementTradeId + ", " +
				"originatingTradeId=" + this.originatingTradeId +
			'}';
		}
	}

	/*********************** Builder Implementation of CompressionActivity  ***********************/
	class CompressionActivityBuilderImpl implements CompressionActivity.CompressionActivityBuilder {
	
		protected CompressionType.CompressionTypeBuilder compressionType;
		protected TradeIdentifier.TradeIdentifierBuilder replacementTradeIdentifier;
		protected List<TradeIdentifier.TradeIdentifierBuilder> originatingTradeIdentifier = new ArrayList<>();
		protected TradeId.TradeIdBuilder replacementTradeId;
		protected List<TradeId.TradeIdBuilder> originatingTradeId = new ArrayList<>();
		
		@Override
		@RosettaAttribute("compressionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("compressionType")
		public CompressionType.CompressionTypeBuilder getCompressionType() {
			return compressionType;
		}
		
		@Override
		public CompressionType.CompressionTypeBuilder getOrCreateCompressionType() {
			CompressionType.CompressionTypeBuilder result;
			if (compressionType!=null) {
				result = compressionType;
			}
			else {
				result = compressionType = CompressionType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("replacementTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("replacementTradeIdentifier")
		public TradeIdentifier.TradeIdentifierBuilder getReplacementTradeIdentifier() {
			return replacementTradeIdentifier;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateReplacementTradeIdentifier() {
			TradeIdentifier.TradeIdentifierBuilder result;
			if (replacementTradeIdentifier!=null) {
				result = replacementTradeIdentifier;
			}
			else {
				result = replacementTradeIdentifier = TradeIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("originatingTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("originatingTradeIdentifier")
		public List<? extends TradeIdentifier.TradeIdentifierBuilder> getOriginatingTradeIdentifier() {
			return originatingTradeIdentifier;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateOriginatingTradeIdentifier(int index) {
			if (originatingTradeIdentifier==null) {
				this.originatingTradeIdentifier = new ArrayList<>();
			}
			return getIndex(originatingTradeIdentifier, index, () -> {
						TradeIdentifier.TradeIdentifierBuilder newOriginatingTradeIdentifier = TradeIdentifier.builder();
						return newOriginatingTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("replacementTradeId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("replacementTradeId")
		public TradeId.TradeIdBuilder getReplacementTradeId() {
			return replacementTradeId;
		}
		
		@Override
		public TradeId.TradeIdBuilder getOrCreateReplacementTradeId() {
			TradeId.TradeIdBuilder result;
			if (replacementTradeId!=null) {
				result = replacementTradeId;
			}
			else {
				result = replacementTradeId = TradeId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("originatingTradeId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("originatingTradeId")
		public List<? extends TradeId.TradeIdBuilder> getOriginatingTradeId() {
			return originatingTradeId;
		}
		
		@Override
		public TradeId.TradeIdBuilder getOrCreateOriginatingTradeId(int index) {
			if (originatingTradeId==null) {
				this.originatingTradeId = new ArrayList<>();
			}
			return getIndex(originatingTradeId, index, () -> {
						TradeId.TradeIdBuilder newOriginatingTradeId = TradeId.builder();
						return newOriginatingTradeId;
					});
		}
		
		@RosettaAttribute("compressionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("compressionType")
		@Override
		public CompressionActivity.CompressionActivityBuilder setCompressionType(CompressionType _compressionType) {
			this.compressionType = _compressionType == null ? null : _compressionType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("replacementTradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("replacementTradeIdentifier")
		@Override
		public CompressionActivity.CompressionActivityBuilder setReplacementTradeIdentifier(TradeIdentifier _replacementTradeIdentifier) {
			this.replacementTradeIdentifier = _replacementTradeIdentifier == null ? null : _replacementTradeIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("originatingTradeIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("originatingTradeIdentifier")
		@Override
		public CompressionActivity.CompressionActivityBuilder addOriginatingTradeIdentifier(TradeIdentifier _originatingTradeIdentifier) {
			if (_originatingTradeIdentifier != null) {
				this.originatingTradeIdentifier.add(_originatingTradeIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public CompressionActivity.CompressionActivityBuilder addOriginatingTradeIdentifier(TradeIdentifier _originatingTradeIdentifier, int idx) {
			getIndex(this.originatingTradeIdentifier, idx, () -> _originatingTradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public CompressionActivity.CompressionActivityBuilder addOriginatingTradeIdentifier(List<? extends TradeIdentifier> originatingTradeIdentifiers) {
			if (originatingTradeIdentifiers != null) {
				for (final TradeIdentifier toAdd : originatingTradeIdentifiers) {
					this.originatingTradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("originatingTradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("originatingTradeIdentifier")
		@Override
		public CompressionActivity.CompressionActivityBuilder setOriginatingTradeIdentifier(List<? extends TradeIdentifier> originatingTradeIdentifiers) {
			if (originatingTradeIdentifiers == null) {
				this.originatingTradeIdentifier = new ArrayList<>();
			} else {
				this.originatingTradeIdentifier = originatingTradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("replacementTradeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("replacementTradeId")
		@Override
		public CompressionActivity.CompressionActivityBuilder setReplacementTradeId(TradeId _replacementTradeId) {
			this.replacementTradeId = _replacementTradeId == null ? null : _replacementTradeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("originatingTradeId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("originatingTradeId")
		@Override
		public CompressionActivity.CompressionActivityBuilder addOriginatingTradeId(TradeId _originatingTradeId) {
			if (_originatingTradeId != null) {
				this.originatingTradeId.add(_originatingTradeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public CompressionActivity.CompressionActivityBuilder addOriginatingTradeId(TradeId _originatingTradeId, int idx) {
			getIndex(this.originatingTradeId, idx, () -> _originatingTradeId.toBuilder());
			return this;
		}
		
		@Override
		public CompressionActivity.CompressionActivityBuilder addOriginatingTradeId(List<? extends TradeId> originatingTradeIds) {
			if (originatingTradeIds != null) {
				for (final TradeId toAdd : originatingTradeIds) {
					this.originatingTradeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("originatingTradeId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("originatingTradeId")
		@Override
		public CompressionActivity.CompressionActivityBuilder setOriginatingTradeId(List<? extends TradeId> originatingTradeIds) {
			if (originatingTradeIds == null) {
				this.originatingTradeId = new ArrayList<>();
			} else {
				this.originatingTradeId = originatingTradeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CompressionActivity build() {
			return new CompressionActivity.CompressionActivityImpl(this);
		}
		
		@Override
		public CompressionActivity.CompressionActivityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CompressionActivity.CompressionActivityBuilder prune() {
			if (compressionType!=null && !compressionType.prune().hasData()) compressionType = null;
			if (replacementTradeIdentifier!=null && !replacementTradeIdentifier.prune().hasData()) replacementTradeIdentifier = null;
			originatingTradeIdentifier = originatingTradeIdentifier.stream().filter(b->b!=null).<TradeIdentifier.TradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (replacementTradeId!=null && !replacementTradeId.prune().hasData()) replacementTradeId = null;
			originatingTradeId = originatingTradeId.stream().filter(b->b!=null).<TradeId.TradeIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCompressionType()!=null && getCompressionType().hasData()) return true;
			if (getReplacementTradeIdentifier()!=null && getReplacementTradeIdentifier().hasData()) return true;
			if (getOriginatingTradeIdentifier()!=null && getOriginatingTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReplacementTradeId()!=null && getReplacementTradeId().hasData()) return true;
			if (getOriginatingTradeId()!=null && getOriginatingTradeId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CompressionActivity.CompressionActivityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CompressionActivity.CompressionActivityBuilder o = (CompressionActivity.CompressionActivityBuilder) other;
			
			merger.mergeRosetta(getCompressionType(), o.getCompressionType(), this::setCompressionType);
			merger.mergeRosetta(getReplacementTradeIdentifier(), o.getReplacementTradeIdentifier(), this::setReplacementTradeIdentifier);
			merger.mergeRosetta(getOriginatingTradeIdentifier(), o.getOriginatingTradeIdentifier(), this::getOrCreateOriginatingTradeIdentifier);
			merger.mergeRosetta(getReplacementTradeId(), o.getReplacementTradeId(), this::setReplacementTradeId);
			merger.mergeRosetta(getOriginatingTradeId(), o.getOriginatingTradeId(), this::getOrCreateOriginatingTradeId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CompressionActivity _that = getType().cast(o);
		
			if (!Objects.equals(compressionType, _that.getCompressionType())) return false;
			if (!Objects.equals(replacementTradeIdentifier, _that.getReplacementTradeIdentifier())) return false;
			if (!ListEquals.listEquals(originatingTradeIdentifier, _that.getOriginatingTradeIdentifier())) return false;
			if (!Objects.equals(replacementTradeId, _that.getReplacementTradeId())) return false;
			if (!ListEquals.listEquals(originatingTradeId, _that.getOriginatingTradeId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (compressionType != null ? compressionType.hashCode() : 0);
			_result = 31 * _result + (replacementTradeIdentifier != null ? replacementTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (originatingTradeIdentifier != null ? originatingTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (replacementTradeId != null ? replacementTradeId.hashCode() : 0);
			_result = 31 * _result + (originatingTradeId != null ? originatingTradeId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CompressionActivityBuilder {" +
				"compressionType=" + this.compressionType + ", " +
				"replacementTradeIdentifier=" + this.replacementTradeIdentifier + ", " +
				"originatingTradeIdentifier=" + this.originatingTradeIdentifier + ", " +
				"replacementTradeId=" + this.replacementTradeId + ", " +
				"originatingTradeId=" + this.originatingTradeId +
			'}';
		}
	}
}

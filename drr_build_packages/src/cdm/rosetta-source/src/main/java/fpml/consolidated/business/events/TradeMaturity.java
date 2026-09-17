package fpml.consolidated.business.events;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.business.events.meta.TradeMaturityMeta;
import fpml.consolidated.doc.PartyTradeIdentifier;
import java.time.ZonedDateTime;
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
 * Provision A structure describing a trade maturing.
 *
 */
@RosettaDataType(value="TradeMaturity", builder=TradeMaturity.TradeMaturityBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TradeMaturity", model="fpml", builder=TradeMaturity.TradeMaturityBuilderImpl.class, version="2.1.1")
public interface TradeMaturity extends RosettaModelObject {

	TradeMaturityMeta metaData = new TradeMaturityMeta();

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
	List<? extends PartyTradeIdentifier> getTradeIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	ZonedDateTime getDate();

	/*********************** Build Methods  ***********************/
	TradeMaturity build();
	
	TradeMaturity.TradeMaturityBuilder toBuilder();
	
	static TradeMaturity.TradeMaturityBuilder builder() {
		return new TradeMaturity.TradeMaturityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeMaturity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeMaturity> getType() {
		return TradeMaturity.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.class, getTradeIdentifier());
		processor.processBasic(path.newSubPath("date"), ZonedDateTime.class, getDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeMaturityBuilder extends TradeMaturity, RosettaModelObjectBuilder {
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier(int index);
		@Override
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getTradeIdentifier();
		TradeMaturity.TradeMaturityBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier);
		TradeMaturity.TradeMaturityBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier, int idx);
		TradeMaturity.TradeMaturityBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier);
		TradeMaturity.TradeMaturityBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier);
		TradeMaturity.TradeMaturityBuilder setDate(ZonedDateTime date);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getTradeIdentifier());
			processor.processBasic(path.newSubPath("date"), ZonedDateTime.class, getDate(), this);
		}
		

		TradeMaturity.TradeMaturityBuilder prune();
	}

	/*********************** Immutable Implementation of TradeMaturity  ***********************/
	class TradeMaturityImpl implements TradeMaturity {
		private final List<? extends PartyTradeIdentifier> tradeIdentifier;
		private final ZonedDateTime date;
		
		protected TradeMaturityImpl(TradeMaturity.TradeMaturityBuilder builder) {
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.date = builder.getDate();
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("tradeIdentifier")
		public List<? extends PartyTradeIdentifier> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("date")
		public ZonedDateTime getDate() {
			return date;
		}
		
		@Override
		public TradeMaturity build() {
			return this;
		}
		
		@Override
		public TradeMaturity.TradeMaturityBuilder toBuilder() {
			TradeMaturity.TradeMaturityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeMaturity.TradeMaturityBuilder builder) {
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getDate()).ifPresent(builder::setDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeMaturity _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeMaturity {" +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"date=" + this.date +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeMaturity  ***********************/
	class TradeMaturityBuilderImpl implements TradeMaturity.TradeMaturityBuilder {
	
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> tradeIdentifier = new ArrayList<>();
		protected ZonedDateTime date;
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("tradeIdentifier")
		public List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier(int index) {
			if (tradeIdentifier==null) {
				this.tradeIdentifier = new ArrayList<>();
			}
			return getIndex(tradeIdentifier, index, () -> {
						PartyTradeIdentifier.PartyTradeIdentifierBuilder newTradeIdentifier = PartyTradeIdentifier.builder();
						return newTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("date")
		public ZonedDateTime getDate() {
			return date;
		}
		
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("tradeIdentifier")
		@Override
		public TradeMaturity.TradeMaturityBuilder addTradeIdentifier(PartyTradeIdentifier _tradeIdentifier) {
			if (_tradeIdentifier != null) {
				this.tradeIdentifier.add(_tradeIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeMaturity.TradeMaturityBuilder addTradeIdentifier(PartyTradeIdentifier _tradeIdentifier, int idx) {
			getIndex(this.tradeIdentifier, idx, () -> _tradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public TradeMaturity.TradeMaturityBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers != null) {
				for (final PartyTradeIdentifier toAdd : tradeIdentifiers) {
					this.tradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("tradeIdentifier")
		@Override
		public TradeMaturity.TradeMaturityBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers == null) {
				this.tradeIdentifier = new ArrayList<>();
			} else {
				this.tradeIdentifier = tradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("date")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("date")
		@Override
		public TradeMaturity.TradeMaturityBuilder setDate(ZonedDateTime _date) {
			this.date = _date == null ? null : _date;
			return this;
		}
		
		@Override
		public TradeMaturity build() {
			return new TradeMaturity.TradeMaturityImpl(this);
		}
		
		@Override
		public TradeMaturity.TradeMaturityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeMaturity.TradeMaturityBuilder prune() {
			tradeIdentifier = tradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradeIdentifier()!=null && getTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeMaturity.TradeMaturityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeMaturity.TradeMaturityBuilder o = (TradeMaturity.TradeMaturityBuilder) other;
			
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::getOrCreateTradeIdentifier);
			
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeMaturity _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeMaturityBuilder {" +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"date=" + this.date +
			'}';
		}
	}
}

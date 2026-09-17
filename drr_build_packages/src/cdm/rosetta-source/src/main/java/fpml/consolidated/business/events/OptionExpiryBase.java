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
import fpml.consolidated.business.events.meta.OptionExpiryBaseMeta;
import fpml.consolidated.doc.PartyTradeIdentifier;
import java.time.LocalTime;
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
 * Provision A structure describing an option expiring.
 *
 */
@RosettaDataType(value="OptionExpiryBase", builder=OptionExpiryBase.OptionExpiryBaseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="OptionExpiryBase", model="fpml", builder=OptionExpiryBase.OptionExpiryBaseBuilderImpl.class, version="2.1.1")
public interface OptionExpiryBase extends RosettaModelObject {

	OptionExpiryBaseMeta metaData = new OptionExpiryBaseMeta();

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
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	LocalTime getTime();

	/*********************** Build Methods  ***********************/
	OptionExpiryBase build();
	
	OptionExpiryBase.OptionExpiryBaseBuilder toBuilder();
	
	static OptionExpiryBase.OptionExpiryBaseBuilder builder() {
		return new OptionExpiryBase.OptionExpiryBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionExpiryBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OptionExpiryBase> getType() {
		return OptionExpiryBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.class, getTradeIdentifier());
		processor.processBasic(path.newSubPath("date"), ZonedDateTime.class, getDate(), this);
		processor.processBasic(path.newSubPath("time"), LocalTime.class, getTime(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionExpiryBaseBuilder extends OptionExpiryBase, RosettaModelObjectBuilder {
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier(int index);
		@Override
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getTradeIdentifier();
		OptionExpiryBase.OptionExpiryBaseBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier);
		OptionExpiryBase.OptionExpiryBaseBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier, int idx);
		OptionExpiryBase.OptionExpiryBaseBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier);
		OptionExpiryBase.OptionExpiryBaseBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier);
		OptionExpiryBase.OptionExpiryBaseBuilder setDate(ZonedDateTime date);
		OptionExpiryBase.OptionExpiryBaseBuilder setTime(LocalTime time);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getTradeIdentifier());
			processor.processBasic(path.newSubPath("date"), ZonedDateTime.class, getDate(), this);
			processor.processBasic(path.newSubPath("time"), LocalTime.class, getTime(), this);
		}
		

		OptionExpiryBase.OptionExpiryBaseBuilder prune();
	}

	/*********************** Immutable Implementation of OptionExpiryBase  ***********************/
	class OptionExpiryBaseImpl implements OptionExpiryBase {
		private final List<? extends PartyTradeIdentifier> tradeIdentifier;
		private final ZonedDateTime date;
		private final LocalTime time;
		
		protected OptionExpiryBaseImpl(OptionExpiryBase.OptionExpiryBaseBuilder builder) {
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.date = builder.getDate();
			this.time = builder.getTime();
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
		@RosettaAttribute("time")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("time")
		public LocalTime getTime() {
			return time;
		}
		
		@Override
		public OptionExpiryBase build() {
			return this;
		}
		
		@Override
		public OptionExpiryBase.OptionExpiryBaseBuilder toBuilder() {
			OptionExpiryBase.OptionExpiryBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionExpiryBase.OptionExpiryBaseBuilder builder) {
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getTime()).ifPresent(builder::setTime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExpiryBase _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExpiryBase {" +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"date=" + this.date + ", " +
				"time=" + this.time +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionExpiryBase  ***********************/
	class OptionExpiryBaseBuilderImpl implements OptionExpiryBase.OptionExpiryBaseBuilder {
	
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> tradeIdentifier = new ArrayList<>();
		protected ZonedDateTime date;
		protected LocalTime time;
		
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
		
		@Override
		@RosettaAttribute("time")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("time")
		public LocalTime getTime() {
			return time;
		}
		
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("tradeIdentifier")
		@Override
		public OptionExpiryBase.OptionExpiryBaseBuilder addTradeIdentifier(PartyTradeIdentifier _tradeIdentifier) {
			if (_tradeIdentifier != null) {
				this.tradeIdentifier.add(_tradeIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public OptionExpiryBase.OptionExpiryBaseBuilder addTradeIdentifier(PartyTradeIdentifier _tradeIdentifier, int idx) {
			getIndex(this.tradeIdentifier, idx, () -> _tradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public OptionExpiryBase.OptionExpiryBaseBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
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
		public OptionExpiryBase.OptionExpiryBaseBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
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
		public OptionExpiryBase.OptionExpiryBaseBuilder setDate(ZonedDateTime _date) {
			this.date = _date == null ? null : _date;
			return this;
		}
		
		@RosettaAttribute("time")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("time")
		@Override
		public OptionExpiryBase.OptionExpiryBaseBuilder setTime(LocalTime _time) {
			this.time = _time == null ? null : _time;
			return this;
		}
		
		@Override
		public OptionExpiryBase build() {
			return new OptionExpiryBase.OptionExpiryBaseImpl(this);
		}
		
		@Override
		public OptionExpiryBase.OptionExpiryBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExpiryBase.OptionExpiryBaseBuilder prune() {
			tradeIdentifier = tradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradeIdentifier()!=null && getTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDate()!=null) return true;
			if (getTime()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExpiryBase.OptionExpiryBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionExpiryBase.OptionExpiryBaseBuilder o = (OptionExpiryBase.OptionExpiryBaseBuilder) other;
			
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::getOrCreateTradeIdentifier);
			
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			merger.mergeBasic(getTime(), o.getTime(), this::setTime);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExpiryBase _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExpiryBaseBuilder {" +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"date=" + this.date + ", " +
				"time=" + this.time +
			'}';
		}
	}
}

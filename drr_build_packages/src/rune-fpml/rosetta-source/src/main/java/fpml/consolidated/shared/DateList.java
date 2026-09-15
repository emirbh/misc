package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.DateListMeta;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision List of Dates
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision List of Dates
 *
 */
@RosettaDataType(value="DateList", builder=DateList.DateListBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DateList", model="fpml", builder=DateList.DateListBuilderImpl.class, version="2.1.1")
public interface DateList extends RosettaModelObject {

	DateListMeta metaData = new DateListMeta();

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
	List<ZonedDateTime> getDate();

	/*********************** Build Methods  ***********************/
	DateList build();
	
	DateList.DateListBuilder toBuilder();
	
	static DateList.DateListBuilder builder() {
		return new DateList.DateListBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DateList> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DateList> getType() {
		return DateList.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("date"), ZonedDateTime.class, getDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DateListBuilder extends DateList, RosettaModelObjectBuilder {
		DateList.DateListBuilder addDate(ZonedDateTime date);
		DateList.DateListBuilder addDate(ZonedDateTime date, int idx);
		DateList.DateListBuilder addDate(List<ZonedDateTime> date);
		DateList.DateListBuilder setDate(List<ZonedDateTime> date);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("date"), ZonedDateTime.class, getDate(), this);
		}
		

		DateList.DateListBuilder prune();
	}

	/*********************** Immutable Implementation of DateList  ***********************/
	class DateListImpl implements DateList {
		private final List<ZonedDateTime> date;
		
		protected DateListImpl(DateList.DateListBuilder builder) {
			this.date = ofNullable(builder.getDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("date")
		public List<ZonedDateTime> getDate() {
			return date;
		}
		
		@Override
		public DateList build() {
			return this;
		}
		
		@Override
		public DateList.DateListBuilder toBuilder() {
			DateList.DateListBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DateList.DateListBuilder builder) {
			ofNullable(getDate()).ifPresent(builder::setDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DateList _that = getType().cast(o);
		
			if (!ListEquals.listEquals(date, _that.getDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateList {" +
				"date=" + this.date +
			'}';
		}
	}

	/*********************** Builder Implementation of DateList  ***********************/
	class DateListBuilderImpl implements DateList.DateListBuilder {
	
		protected List<ZonedDateTime> date = new ArrayList<>();
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("date")
		public List<ZonedDateTime> getDate() {
			return date;
		}
		
		@RosettaAttribute("date")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("date")
		@Override
		public DateList.DateListBuilder addDate(ZonedDateTime _date) {
			if (_date != null) {
				this.date.add(_date);
			}
			return this;
		}
		
		@Override
		public DateList.DateListBuilder addDate(ZonedDateTime _date, int idx) {
			getIndex(this.date, idx, () -> _date);
			return this;
		}
		
		@Override
		public DateList.DateListBuilder addDate(List<ZonedDateTime> dates) {
			if (dates != null) {
				for (final ZonedDateTime toAdd : dates) {
					this.date.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("date")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("date")
		@Override
		public DateList.DateListBuilder setDate(List<ZonedDateTime> dates) {
			if (dates == null) {
				this.date = new ArrayList<>();
			} else {
				this.date = dates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public DateList build() {
			return new DateList.DateListImpl(this);
		}
		
		@Override
		public DateList.DateListBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateList.DateListBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDate()!=null && !getDate().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateList.DateListBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DateList.DateListBuilder o = (DateList.DateListBuilder) other;
			
			
			merger.mergeBasic(getDate(), o.getDate(), (Consumer<ZonedDateTime>) this::addDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DateList _that = getType().cast(o);
		
			if (!ListEquals.listEquals(date, _that.getDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateListBuilder {" +
				"date=" + this.date +
			'}';
		}
	}
}

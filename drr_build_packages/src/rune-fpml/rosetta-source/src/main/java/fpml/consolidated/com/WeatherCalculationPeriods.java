package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.WeatherCalculationPeriodsMeta;
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
 * version "recordkeeping-5.13"
 *
 * Provision The schedule of Calculation Period First Days and Lasts Days. If there is only one First Day - Last Day pair then the First is equal to the Effective Date and the Last Day is equal to the Termination Date.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The schedule of Calculation Period First Days and Lasts Days. If there is only one First Day - Last Day pair then the First is equal to the Effective Date and the Last Day is equal to the Termination Date.
 *
 */
@RosettaDataType(value="WeatherCalculationPeriods", builder=WeatherCalculationPeriods.WeatherCalculationPeriodsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="WeatherCalculationPeriods", model="fpml", builder=WeatherCalculationPeriods.WeatherCalculationPeriodsBuilderImpl.class, version="2.1.1")
public interface WeatherCalculationPeriods extends RosettaModelObject {

	WeatherCalculationPeriodsMeta metaData = new WeatherCalculationPeriodsMeta();

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
	String getId();
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
	List<? extends WeatherCalculationPeriod> getCalculationPeriod();

	/*********************** Build Methods  ***********************/
	WeatherCalculationPeriods build();
	
	WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder toBuilder();
	
	static WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder builder() {
		return new WeatherCalculationPeriods.WeatherCalculationPeriodsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WeatherCalculationPeriods> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends WeatherCalculationPeriods> getType() {
		return WeatherCalculationPeriods.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("calculationPeriod"), processor, WeatherCalculationPeriod.class, getCalculationPeriod());
	}
	

	/*********************** Builder Interface  ***********************/
	interface WeatherCalculationPeriodsBuilder extends WeatherCalculationPeriods, RosettaModelObjectBuilder {
		WeatherCalculationPeriod.WeatherCalculationPeriodBuilder getOrCreateCalculationPeriod(int index);
		@Override
		List<? extends WeatherCalculationPeriod.WeatherCalculationPeriodBuilder> getCalculationPeriod();
		WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder setId(String id);
		WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder addCalculationPeriod(WeatherCalculationPeriod calculationPeriod);
		WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder addCalculationPeriod(WeatherCalculationPeriod calculationPeriod, int idx);
		WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder addCalculationPeriod(List<? extends WeatherCalculationPeriod> calculationPeriod);
		WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder setCalculationPeriod(List<? extends WeatherCalculationPeriod> calculationPeriod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("calculationPeriod"), processor, WeatherCalculationPeriod.WeatherCalculationPeriodBuilder.class, getCalculationPeriod());
		}
		

		WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder prune();
	}

	/*********************** Immutable Implementation of WeatherCalculationPeriods  ***********************/
	class WeatherCalculationPeriodsImpl implements WeatherCalculationPeriods {
		private final String id;
		private final List<? extends WeatherCalculationPeriod> calculationPeriod;
		
		protected WeatherCalculationPeriodsImpl(WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder builder) {
			this.id = builder.getId();
			this.calculationPeriod = ofNullable(builder.getCalculationPeriod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("calculationPeriod")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("calculationPeriod")
		public List<? extends WeatherCalculationPeriod> getCalculationPeriod() {
			return calculationPeriod;
		}
		
		@Override
		public WeatherCalculationPeriods build() {
			return this;
		}
		
		@Override
		public WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder toBuilder() {
			WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getCalculationPeriod()).ifPresent(builder::setCalculationPeriod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherCalculationPeriods _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(calculationPeriod, _that.getCalculationPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (calculationPeriod != null ? calculationPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherCalculationPeriods {" +
				"id=" + this.id + ", " +
				"calculationPeriod=" + this.calculationPeriod +
			'}';
		}
	}

	/*********************** Builder Implementation of WeatherCalculationPeriods  ***********************/
	class WeatherCalculationPeriodsBuilderImpl implements WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder {
	
		protected String id;
		protected List<WeatherCalculationPeriod.WeatherCalculationPeriodBuilder> calculationPeriod = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("calculationPeriod")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("calculationPeriod")
		public List<? extends WeatherCalculationPeriod.WeatherCalculationPeriodBuilder> getCalculationPeriod() {
			return calculationPeriod;
		}
		
		@Override
		public WeatherCalculationPeriod.WeatherCalculationPeriodBuilder getOrCreateCalculationPeriod(int index) {
			if (calculationPeriod==null) {
				this.calculationPeriod = new ArrayList<>();
			}
			return getIndex(calculationPeriod, index, () -> {
						WeatherCalculationPeriod.WeatherCalculationPeriodBuilder newCalculationPeriod = WeatherCalculationPeriod.builder();
						return newCalculationPeriod;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("calculationPeriod")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("calculationPeriod")
		@Override
		public WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder addCalculationPeriod(WeatherCalculationPeriod _calculationPeriod) {
			if (_calculationPeriod != null) {
				this.calculationPeriod.add(_calculationPeriod.toBuilder());
			}
			return this;
		}
		
		@Override
		public WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder addCalculationPeriod(WeatherCalculationPeriod _calculationPeriod, int idx) {
			getIndex(this.calculationPeriod, idx, () -> _calculationPeriod.toBuilder());
			return this;
		}
		
		@Override
		public WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder addCalculationPeriod(List<? extends WeatherCalculationPeriod> calculationPeriods) {
			if (calculationPeriods != null) {
				for (final WeatherCalculationPeriod toAdd : calculationPeriods) {
					this.calculationPeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("calculationPeriod")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("calculationPeriod")
		@Override
		public WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder setCalculationPeriod(List<? extends WeatherCalculationPeriod> calculationPeriods) {
			if (calculationPeriods == null) {
				this.calculationPeriod = new ArrayList<>();
			} else {
				this.calculationPeriod = calculationPeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public WeatherCalculationPeriods build() {
			return new WeatherCalculationPeriods.WeatherCalculationPeriodsImpl(this);
		}
		
		@Override
		public WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder prune() {
			calculationPeriod = calculationPeriod.stream().filter(b->b!=null).<WeatherCalculationPeriod.WeatherCalculationPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getCalculationPeriod()!=null && getCalculationPeriod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder o = (WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder) other;
			
			merger.mergeRosetta(getCalculationPeriod(), o.getCalculationPeriod(), this::getOrCreateCalculationPeriod);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherCalculationPeriods _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(calculationPeriod, _that.getCalculationPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (calculationPeriod != null ? calculationPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherCalculationPeriodsBuilder {" +
				"id=" + this.id + ", " +
				"calculationPeriod=" + this.calculationPeriod +
			'}';
		}
	}
}

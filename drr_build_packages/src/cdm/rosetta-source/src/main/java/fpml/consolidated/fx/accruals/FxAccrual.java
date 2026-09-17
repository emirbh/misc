package fpml.consolidated.fx.accruals;

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
import fpml.consolidated.fx.accruals.meta.FxAccrualMeta;
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
 * Provision Accrual calculation process.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Accrual calculation process.
 *
 */
@RosettaDataType(value="FxAccrual", builder=FxAccrual.FxAccrualBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxAccrual", model="fpml", builder=FxAccrual.FxAccrualBuilderImpl.class, version="2.1.1")
public interface FxAccrual extends RosettaModelObject {

	FxAccrualMeta metaData = new FxAccrualMeta();

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
	 * Provision Contains the quoted currency pair, and the information source for fixing FX rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Contains the quoted currency pair, and the information source for fixing FX rate.
	 *
	 */
	List<? extends FxRateObservable> getObservable();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the regions of the spot rate where fixings generate an accumulation of notional.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the regions of the spot rate where fixings generate an accumulation of notional.
	 *
	 */
	List<? extends FxAccrualRegion> getAccrualRegion();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Describes a parametric schedule of fixing dates.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes a parametric schedule of fixing dates.
	 *
	 */
	FxFixingSchedule getFixingSchedule();

	/*********************** Build Methods  ***********************/
	FxAccrual build();
	
	FxAccrual.FxAccrualBuilder toBuilder();
	
	static FxAccrual.FxAccrualBuilder builder() {
		return new FxAccrual.FxAccrualBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrual> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxAccrual> getType() {
		return FxAccrual.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("observable"), processor, FxRateObservable.class, getObservable());
		processRosetta(path.newSubPath("accrualRegion"), processor, FxAccrualRegion.class, getAccrualRegion());
		processRosetta(path.newSubPath("fixingSchedule"), processor, FxFixingSchedule.class, getFixingSchedule());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualBuilder extends FxAccrual, RosettaModelObjectBuilder {
		FxRateObservable.FxRateObservableBuilder getOrCreateObservable(int index);
		@Override
		List<? extends FxRateObservable.FxRateObservableBuilder> getObservable();
		FxAccrualRegion.FxAccrualRegionBuilder getOrCreateAccrualRegion(int index);
		@Override
		List<? extends FxAccrualRegion.FxAccrualRegionBuilder> getAccrualRegion();
		FxFixingSchedule.FxFixingScheduleBuilder getOrCreateFixingSchedule();
		@Override
		FxFixingSchedule.FxFixingScheduleBuilder getFixingSchedule();
		FxAccrual.FxAccrualBuilder setId(String id);
		FxAccrual.FxAccrualBuilder addObservable(FxRateObservable observable);
		FxAccrual.FxAccrualBuilder addObservable(FxRateObservable observable, int idx);
		FxAccrual.FxAccrualBuilder addObservable(List<? extends FxRateObservable> observable);
		FxAccrual.FxAccrualBuilder setObservable(List<? extends FxRateObservable> observable);
		FxAccrual.FxAccrualBuilder addAccrualRegion(FxAccrualRegion accrualRegion);
		FxAccrual.FxAccrualBuilder addAccrualRegion(FxAccrualRegion accrualRegion, int idx);
		FxAccrual.FxAccrualBuilder addAccrualRegion(List<? extends FxAccrualRegion> accrualRegion);
		FxAccrual.FxAccrualBuilder setAccrualRegion(List<? extends FxAccrualRegion> accrualRegion);
		FxAccrual.FxAccrualBuilder setFixingSchedule(FxFixingSchedule fixingSchedule);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("observable"), processor, FxRateObservable.FxRateObservableBuilder.class, getObservable());
			processRosetta(path.newSubPath("accrualRegion"), processor, FxAccrualRegion.FxAccrualRegionBuilder.class, getAccrualRegion());
			processRosetta(path.newSubPath("fixingSchedule"), processor, FxFixingSchedule.FxFixingScheduleBuilder.class, getFixingSchedule());
		}
		

		FxAccrual.FxAccrualBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrual  ***********************/
	class FxAccrualImpl implements FxAccrual {
		private final String id;
		private final List<? extends FxRateObservable> observable;
		private final List<? extends FxAccrualRegion> accrualRegion;
		private final FxFixingSchedule fixingSchedule;
		
		protected FxAccrualImpl(FxAccrual.FxAccrualBuilder builder) {
			this.id = builder.getId();
			this.observable = ofNullable(builder.getObservable()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.accrualRegion = ofNullable(builder.getAccrualRegion()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.fixingSchedule = ofNullable(builder.getFixingSchedule()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("observable")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("observable")
		public List<? extends FxRateObservable> getObservable() {
			return observable;
		}
		
		@Override
		@RosettaAttribute("accrualRegion")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("accrualRegion")
		public List<? extends FxAccrualRegion> getAccrualRegion() {
			return accrualRegion;
		}
		
		@Override
		@RosettaAttribute("fixingSchedule")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fixingSchedule")
		public FxFixingSchedule getFixingSchedule() {
			return fixingSchedule;
		}
		
		@Override
		public FxAccrual build() {
			return this;
		}
		
		@Override
		public FxAccrual.FxAccrualBuilder toBuilder() {
			FxAccrual.FxAccrualBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrual.FxAccrualBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getObservable()).ifPresent(builder::setObservable);
			ofNullable(getAccrualRegion()).ifPresent(builder::setAccrualRegion);
			ofNullable(getFixingSchedule()).ifPresent(builder::setFixingSchedule);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrual _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(observable, _that.getObservable())) return false;
			if (!ListEquals.listEquals(accrualRegion, _that.getAccrualRegion())) return false;
			if (!Objects.equals(fixingSchedule, _that.getFixingSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (observable != null ? observable.hashCode() : 0);
			_result = 31 * _result + (accrualRegion != null ? accrualRegion.hashCode() : 0);
			_result = 31 * _result + (fixingSchedule != null ? fixingSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrual {" +
				"id=" + this.id + ", " +
				"observable=" + this.observable + ", " +
				"accrualRegion=" + this.accrualRegion + ", " +
				"fixingSchedule=" + this.fixingSchedule +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAccrual  ***********************/
	class FxAccrualBuilderImpl implements FxAccrual.FxAccrualBuilder {
	
		protected String id;
		protected List<FxRateObservable.FxRateObservableBuilder> observable = new ArrayList<>();
		protected List<FxAccrualRegion.FxAccrualRegionBuilder> accrualRegion = new ArrayList<>();
		protected FxFixingSchedule.FxFixingScheduleBuilder fixingSchedule;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("observable")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("observable")
		public List<? extends FxRateObservable.FxRateObservableBuilder> getObservable() {
			return observable;
		}
		
		@Override
		public FxRateObservable.FxRateObservableBuilder getOrCreateObservable(int index) {
			if (observable==null) {
				this.observable = new ArrayList<>();
			}
			return getIndex(observable, index, () -> {
						FxRateObservable.FxRateObservableBuilder newObservable = FxRateObservable.builder();
						return newObservable;
					});
		}
		
		@Override
		@RosettaAttribute("accrualRegion")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("accrualRegion")
		public List<? extends FxAccrualRegion.FxAccrualRegionBuilder> getAccrualRegion() {
			return accrualRegion;
		}
		
		@Override
		public FxAccrualRegion.FxAccrualRegionBuilder getOrCreateAccrualRegion(int index) {
			if (accrualRegion==null) {
				this.accrualRegion = new ArrayList<>();
			}
			return getIndex(accrualRegion, index, () -> {
						FxAccrualRegion.FxAccrualRegionBuilder newAccrualRegion = FxAccrualRegion.builder();
						return newAccrualRegion;
					});
		}
		
		@Override
		@RosettaAttribute("fixingSchedule")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fixingSchedule")
		public FxFixingSchedule.FxFixingScheduleBuilder getFixingSchedule() {
			return fixingSchedule;
		}
		
		@Override
		public FxFixingSchedule.FxFixingScheduleBuilder getOrCreateFixingSchedule() {
			FxFixingSchedule.FxFixingScheduleBuilder result;
			if (fixingSchedule!=null) {
				result = fixingSchedule;
			}
			else {
				result = fixingSchedule = FxFixingSchedule.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxAccrual.FxAccrualBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("observable")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("observable")
		@Override
		public FxAccrual.FxAccrualBuilder addObservable(FxRateObservable _observable) {
			if (_observable != null) {
				this.observable.add(_observable.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrual.FxAccrualBuilder addObservable(FxRateObservable _observable, int idx) {
			getIndex(this.observable, idx, () -> _observable.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrual.FxAccrualBuilder addObservable(List<? extends FxRateObservable> observables) {
			if (observables != null) {
				for (final FxRateObservable toAdd : observables) {
					this.observable.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("observable")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("observable")
		@Override
		public FxAccrual.FxAccrualBuilder setObservable(List<? extends FxRateObservable> observables) {
			if (observables == null) {
				this.observable = new ArrayList<>();
			} else {
				this.observable = observables.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("accrualRegion")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("accrualRegion")
		@Override
		public FxAccrual.FxAccrualBuilder addAccrualRegion(FxAccrualRegion _accrualRegion) {
			if (_accrualRegion != null) {
				this.accrualRegion.add(_accrualRegion.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrual.FxAccrualBuilder addAccrualRegion(FxAccrualRegion _accrualRegion, int idx) {
			getIndex(this.accrualRegion, idx, () -> _accrualRegion.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrual.FxAccrualBuilder addAccrualRegion(List<? extends FxAccrualRegion> accrualRegions) {
			if (accrualRegions != null) {
				for (final FxAccrualRegion toAdd : accrualRegions) {
					this.accrualRegion.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("accrualRegion")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("accrualRegion")
		@Override
		public FxAccrual.FxAccrualBuilder setAccrualRegion(List<? extends FxAccrualRegion> accrualRegions) {
			if (accrualRegions == null) {
				this.accrualRegion = new ArrayList<>();
			} else {
				this.accrualRegion = accrualRegions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("fixingSchedule")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fixingSchedule")
		@Override
		public FxAccrual.FxAccrualBuilder setFixingSchedule(FxFixingSchedule _fixingSchedule) {
			this.fixingSchedule = _fixingSchedule == null ? null : _fixingSchedule.toBuilder();
			return this;
		}
		
		@Override
		public FxAccrual build() {
			return new FxAccrual.FxAccrualImpl(this);
		}
		
		@Override
		public FxAccrual.FxAccrualBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrual.FxAccrualBuilder prune() {
			observable = observable.stream().filter(b->b!=null).<FxRateObservable.FxRateObservableBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			accrualRegion = accrualRegion.stream().filter(b->b!=null).<FxAccrualRegion.FxAccrualRegionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (fixingSchedule!=null && !fixingSchedule.prune().hasData()) fixingSchedule = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getObservable()!=null && getObservable().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccrualRegion()!=null && getAccrualRegion().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFixingSchedule()!=null && getFixingSchedule().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrual.FxAccrualBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAccrual.FxAccrualBuilder o = (FxAccrual.FxAccrualBuilder) other;
			
			merger.mergeRosetta(getObservable(), o.getObservable(), this::getOrCreateObservable);
			merger.mergeRosetta(getAccrualRegion(), o.getAccrualRegion(), this::getOrCreateAccrualRegion);
			merger.mergeRosetta(getFixingSchedule(), o.getFixingSchedule(), this::setFixingSchedule);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrual _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(observable, _that.getObservable())) return false;
			if (!ListEquals.listEquals(accrualRegion, _that.getAccrualRegion())) return false;
			if (!Objects.equals(fixingSchedule, _that.getFixingSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (observable != null ? observable.hashCode() : 0);
			_result = 31 * _result + (accrualRegion != null ? accrualRegion.hashCode() : 0);
			_result = 31 * _result + (fixingSchedule != null ? fixingSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualBuilder {" +
				"id=" + this.id + ", " +
				"observable=" + this.observable + ", " +
				"accrualRegion=" + this.accrualRegion + ", " +
				"fixingSchedule=" + this.fixingSchedule +
			'}';
		}
	}
}

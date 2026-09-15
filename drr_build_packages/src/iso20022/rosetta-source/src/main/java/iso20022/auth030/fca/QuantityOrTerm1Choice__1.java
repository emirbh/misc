package iso20022.auth030.fca;

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
import iso20022.auth030.fca.meta.QuantityOrTerm1Choice__1Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Indicates the schedule or frequency of the derivative transactions.
 * @version ${project.version}
 */
@RosettaDataType(value="QuantityOrTerm1Choice__1", builder=QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="QuantityOrTerm1Choice__1", model="iso20022", builder=QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1BuilderImpl.class, version="${project.version}")
public interface QuantityOrTerm1Choice__1 extends RosettaModelObject {

	QuantityOrTerm1Choice__1Meta metaData = new QuantityOrTerm1Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the effective date and end date of the schedule for derivative transactions negotiated in non-monetary amounts with a notional quantity varying throughout the life of the transaction.
	 */
	List<? extends Schedule10__1> getSchdlPrd();

	/*********************** Build Methods  ***********************/
	QuantityOrTerm1Choice__1 build();
	
	QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder toBuilder();
	
	static QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder builder() {
		return new QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends QuantityOrTerm1Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends QuantityOrTerm1Choice__1> getType() {
		return QuantityOrTerm1Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("schdlPrd"), processor, Schedule10__1.class, getSchdlPrd());
	}
	

	/*********************** Builder Interface  ***********************/
	interface QuantityOrTerm1Choice__1Builder extends QuantityOrTerm1Choice__1, RosettaModelObjectBuilder {
		Schedule10__1.Schedule10__1Builder getOrCreateSchdlPrd(int index);
		@Override
		List<? extends Schedule10__1.Schedule10__1Builder> getSchdlPrd();
		QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder addSchdlPrd(Schedule10__1 schdlPrd);
		QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder addSchdlPrd(Schedule10__1 schdlPrd, int idx);
		QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder addSchdlPrd(List<? extends Schedule10__1> schdlPrd);
		QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder setSchdlPrd(List<? extends Schedule10__1> schdlPrd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("schdlPrd"), processor, Schedule10__1.Schedule10__1Builder.class, getSchdlPrd());
		}
		

		QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of QuantityOrTerm1Choice__1  ***********************/
	class QuantityOrTerm1Choice__1Impl implements QuantityOrTerm1Choice__1 {
		private final List<? extends Schedule10__1> schdlPrd;
		
		protected QuantityOrTerm1Choice__1Impl(QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder builder) {
			this.schdlPrd = ofNullable(builder.getSchdlPrd()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("schdlPrd")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("schdlPrd")
		public List<? extends Schedule10__1> getSchdlPrd() {
			return schdlPrd;
		}
		
		@Override
		public QuantityOrTerm1Choice__1 build() {
			return this;
		}
		
		@Override
		public QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder toBuilder() {
			QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder builder) {
			ofNullable(getSchdlPrd()).ifPresent(builder::setSchdlPrd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuantityOrTerm1Choice__1 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(schdlPrd, _that.getSchdlPrd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (schdlPrd != null ? schdlPrd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuantityOrTerm1Choice__1 {" +
				"schdlPrd=" + this.schdlPrd +
			'}';
		}
	}

	/*********************** Builder Implementation of QuantityOrTerm1Choice__1  ***********************/
	class QuantityOrTerm1Choice__1BuilderImpl implements QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder {
	
		protected List<Schedule10__1.Schedule10__1Builder> schdlPrd = new ArrayList<>();
		
		@Override
		@RosettaAttribute("schdlPrd")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("schdlPrd")
		public List<? extends Schedule10__1.Schedule10__1Builder> getSchdlPrd() {
			return schdlPrd;
		}
		
		@Override
		public Schedule10__1.Schedule10__1Builder getOrCreateSchdlPrd(int index) {
			if (schdlPrd==null) {
				this.schdlPrd = new ArrayList<>();
			}
			return getIndex(schdlPrd, index, () -> {
						Schedule10__1.Schedule10__1Builder newSchdlPrd = Schedule10__1.builder();
						return newSchdlPrd;
					});
		}
		
		@RosettaAttribute("schdlPrd")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("schdlPrd")
		@Override
		public QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder addSchdlPrd(Schedule10__1 _schdlPrd) {
			if (_schdlPrd != null) {
				this.schdlPrd.add(_schdlPrd.toBuilder());
			}
			return this;
		}
		
		@Override
		public QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder addSchdlPrd(Schedule10__1 _schdlPrd, int idx) {
			getIndex(this.schdlPrd, idx, () -> _schdlPrd.toBuilder());
			return this;
		}
		
		@Override
		public QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder addSchdlPrd(List<? extends Schedule10__1> schdlPrds) {
			if (schdlPrds != null) {
				for (final Schedule10__1 toAdd : schdlPrds) {
					this.schdlPrd.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("schdlPrd")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("schdlPrd")
		@Override
		public QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder setSchdlPrd(List<? extends Schedule10__1> schdlPrds) {
			if (schdlPrds == null) {
				this.schdlPrd = new ArrayList<>();
			} else {
				this.schdlPrd = schdlPrds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public QuantityOrTerm1Choice__1 build() {
			return new QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Impl(this);
		}
		
		@Override
		public QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder prune() {
			schdlPrd = schdlPrd.stream().filter(b->b!=null).<Schedule10__1.Schedule10__1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSchdlPrd()!=null && getSchdlPrd().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder o = (QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder) other;
			
			merger.mergeRosetta(getSchdlPrd(), o.getSchdlPrd(), this::getOrCreateSchdlPrd);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuantityOrTerm1Choice__1 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(schdlPrd, _that.getSchdlPrd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (schdlPrd != null ? schdlPrd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuantityOrTerm1Choice__1Builder {" +
				"schdlPrd=" + this.schdlPrd +
			'}';
		}
	}
}

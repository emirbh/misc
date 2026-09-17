package cdm.product.template;

import cdm.observable.event.TriggerEvent;
import cdm.product.template.meta.KnockMeta;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Knock In means option to exercise comes into existence. Knock Out means option to exercise goes out of existence.
 * @version 6.23.0
 */
@RosettaDataType(value="Knock", builder=Knock.KnockBuilderImpl.class, version="6.23.0")
@RuneDataType(value="Knock", model="cdm", builder=Knock.KnockBuilderImpl.class, version="6.23.0")
public interface Knock extends RosettaModelObject {

	KnockMeta metaData = new KnockMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The knock in.
	 */
	List<? extends TriggerEvent> getKnockIn();
	/**
	 * The knock out.
	 */
	List<? extends TriggerEvent> getKnockOut();

	/*********************** Build Methods  ***********************/
	Knock build();
	
	Knock.KnockBuilder toBuilder();
	
	static Knock.KnockBuilder builder() {
		return new Knock.KnockBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Knock> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Knock> getType() {
		return Knock.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("knockIn"), processor, TriggerEvent.class, getKnockIn());
		processRosetta(path.newSubPath("knockOut"), processor, TriggerEvent.class, getKnockOut());
	}
	

	/*********************** Builder Interface  ***********************/
	interface KnockBuilder extends Knock, RosettaModelObjectBuilder {
		TriggerEvent.TriggerEventBuilder getOrCreateKnockIn(int index);
		@Override
		List<? extends TriggerEvent.TriggerEventBuilder> getKnockIn();
		TriggerEvent.TriggerEventBuilder getOrCreateKnockOut(int index);
		@Override
		List<? extends TriggerEvent.TriggerEventBuilder> getKnockOut();
		Knock.KnockBuilder addKnockIn(TriggerEvent knockIn);
		Knock.KnockBuilder addKnockIn(TriggerEvent knockIn, int idx);
		Knock.KnockBuilder addKnockIn(List<? extends TriggerEvent> knockIn);
		Knock.KnockBuilder setKnockIn(List<? extends TriggerEvent> knockIn);
		Knock.KnockBuilder addKnockOut(TriggerEvent knockOut);
		Knock.KnockBuilder addKnockOut(TriggerEvent knockOut, int idx);
		Knock.KnockBuilder addKnockOut(List<? extends TriggerEvent> knockOut);
		Knock.KnockBuilder setKnockOut(List<? extends TriggerEvent> knockOut);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("knockIn"), processor, TriggerEvent.TriggerEventBuilder.class, getKnockIn());
			processRosetta(path.newSubPath("knockOut"), processor, TriggerEvent.TriggerEventBuilder.class, getKnockOut());
		}
		

		Knock.KnockBuilder prune();
	}

	/*********************** Immutable Implementation of Knock  ***********************/
	class KnockImpl implements Knock {
		private final List<? extends TriggerEvent> knockIn;
		private final List<? extends TriggerEvent> knockOut;
		
		protected KnockImpl(Knock.KnockBuilder builder) {
			this.knockIn = ofNullable(builder.getKnockIn()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.knockOut = ofNullable(builder.getKnockOut()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("knockIn")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("knockIn")
		public List<? extends TriggerEvent> getKnockIn() {
			return knockIn;
		}
		
		@Override
		@RosettaAttribute("knockOut")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("knockOut")
		public List<? extends TriggerEvent> getKnockOut() {
			return knockOut;
		}
		
		@Override
		public Knock build() {
			return this;
		}
		
		@Override
		public Knock.KnockBuilder toBuilder() {
			Knock.KnockBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Knock.KnockBuilder builder) {
			ofNullable(getKnockIn()).ifPresent(builder::setKnockIn);
			ofNullable(getKnockOut()).ifPresent(builder::setKnockOut);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Knock _that = getType().cast(o);
		
			if (!ListEquals.listEquals(knockIn, _that.getKnockIn())) return false;
			if (!ListEquals.listEquals(knockOut, _that.getKnockOut())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (knockIn != null ? knockIn.hashCode() : 0);
			_result = 31 * _result + (knockOut != null ? knockOut.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Knock {" +
				"knockIn=" + this.knockIn + ", " +
				"knockOut=" + this.knockOut +
			'}';
		}
	}

	/*********************** Builder Implementation of Knock  ***********************/
	class KnockBuilderImpl implements Knock.KnockBuilder {
	
		protected List<TriggerEvent.TriggerEventBuilder> knockIn = new ArrayList<>();
		protected List<TriggerEvent.TriggerEventBuilder> knockOut = new ArrayList<>();
		
		@Override
		@RosettaAttribute("knockIn")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("knockIn")
		public List<? extends TriggerEvent.TriggerEventBuilder> getKnockIn() {
			return knockIn;
		}
		
		@Override
		public TriggerEvent.TriggerEventBuilder getOrCreateKnockIn(int index) {
			if (knockIn==null) {
				this.knockIn = new ArrayList<>();
			}
			return getIndex(knockIn, index, () -> {
						TriggerEvent.TriggerEventBuilder newKnockIn = TriggerEvent.builder();
						return newKnockIn;
					});
		}
		
		@Override
		@RosettaAttribute("knockOut")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("knockOut")
		public List<? extends TriggerEvent.TriggerEventBuilder> getKnockOut() {
			return knockOut;
		}
		
		@Override
		public TriggerEvent.TriggerEventBuilder getOrCreateKnockOut(int index) {
			if (knockOut==null) {
				this.knockOut = new ArrayList<>();
			}
			return getIndex(knockOut, index, () -> {
						TriggerEvent.TriggerEventBuilder newKnockOut = TriggerEvent.builder();
						return newKnockOut;
					});
		}
		
		@RosettaAttribute("knockIn")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("knockIn")
		@Override
		public Knock.KnockBuilder addKnockIn(TriggerEvent _knockIn) {
			if (_knockIn != null) {
				this.knockIn.add(_knockIn.toBuilder());
			}
			return this;
		}
		
		@Override
		public Knock.KnockBuilder addKnockIn(TriggerEvent _knockIn, int idx) {
			getIndex(this.knockIn, idx, () -> _knockIn.toBuilder());
			return this;
		}
		
		@Override
		public Knock.KnockBuilder addKnockIn(List<? extends TriggerEvent> knockIns) {
			if (knockIns != null) {
				for (final TriggerEvent toAdd : knockIns) {
					this.knockIn.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("knockIn")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("knockIn")
		@Override
		public Knock.KnockBuilder setKnockIn(List<? extends TriggerEvent> knockIns) {
			if (knockIns == null) {
				this.knockIn = new ArrayList<>();
			} else {
				this.knockIn = knockIns.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("knockOut")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("knockOut")
		@Override
		public Knock.KnockBuilder addKnockOut(TriggerEvent _knockOut) {
			if (_knockOut != null) {
				this.knockOut.add(_knockOut.toBuilder());
			}
			return this;
		}
		
		@Override
		public Knock.KnockBuilder addKnockOut(TriggerEvent _knockOut, int idx) {
			getIndex(this.knockOut, idx, () -> _knockOut.toBuilder());
			return this;
		}
		
		@Override
		public Knock.KnockBuilder addKnockOut(List<? extends TriggerEvent> knockOuts) {
			if (knockOuts != null) {
				for (final TriggerEvent toAdd : knockOuts) {
					this.knockOut.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("knockOut")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("knockOut")
		@Override
		public Knock.KnockBuilder setKnockOut(List<? extends TriggerEvent> knockOuts) {
			if (knockOuts == null) {
				this.knockOut = new ArrayList<>();
			} else {
				this.knockOut = knockOuts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Knock build() {
			return new Knock.KnockImpl(this);
		}
		
		@Override
		public Knock.KnockBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Knock.KnockBuilder prune() {
			knockIn = knockIn.stream().filter(b->b!=null).<TriggerEvent.TriggerEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			knockOut = knockOut.stream().filter(b->b!=null).<TriggerEvent.TriggerEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getKnockIn()!=null && getKnockIn().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getKnockOut()!=null && getKnockOut().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Knock.KnockBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Knock.KnockBuilder o = (Knock.KnockBuilder) other;
			
			merger.mergeRosetta(getKnockIn(), o.getKnockIn(), this::getOrCreateKnockIn);
			merger.mergeRosetta(getKnockOut(), o.getKnockOut(), this::getOrCreateKnockOut);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Knock _that = getType().cast(o);
		
			if (!ListEquals.listEquals(knockIn, _that.getKnockIn())) return false;
			if (!ListEquals.listEquals(knockOut, _that.getKnockOut())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (knockIn != null ? knockIn.hashCode() : 0);
			_result = 31 * _result + (knockOut != null ? knockOut.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "KnockBuilder {" +
				"knockIn=" + this.knockIn + ", " +
				"knockOut=" + this.knockOut +
			'}';
		}
	}
}

package drr.regulation.common;

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
import com.rosetta.model.lib.records.Date;
import drr.regulation.common.meta.LastFloatingReferenceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="LastFloatingReference", builder=LastFloatingReference.LastFloatingReferenceBuilderImpl.class, version="7.7.0")
@RuneDataType(value="LastFloatingReference", model="drr", builder=LastFloatingReference.LastFloatingReferenceBuilderImpl.class, version="7.7.0")
public interface LastFloatingReference extends RosettaModelObject {

	LastFloatingReferenceMeta metaData = new LastFloatingReferenceMeta();

	/*********************** Getter Methods  ***********************/
	Date getLastFloatingReferenceResetDateLeg1();
	Date getLastFloatingReferenceResetDateLeg2();
	BigDecimal getLastFloatingReferenceValueLeg1();
	BigDecimal getLastFloatingReferenceValueLeg2();

	/*********************** Build Methods  ***********************/
	LastFloatingReference build();
	
	LastFloatingReference.LastFloatingReferenceBuilder toBuilder();
	
	static LastFloatingReference.LastFloatingReferenceBuilder builder() {
		return new LastFloatingReference.LastFloatingReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LastFloatingReference> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LastFloatingReference> getType() {
		return LastFloatingReference.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("lastFloatingReferenceResetDateLeg1"), Date.class, getLastFloatingReferenceResetDateLeg1(), this);
		processor.processBasic(path.newSubPath("lastFloatingReferenceResetDateLeg2"), Date.class, getLastFloatingReferenceResetDateLeg2(), this);
		processor.processBasic(path.newSubPath("lastFloatingReferenceValueLeg1"), BigDecimal.class, getLastFloatingReferenceValueLeg1(), this);
		processor.processBasic(path.newSubPath("lastFloatingReferenceValueLeg2"), BigDecimal.class, getLastFloatingReferenceValueLeg2(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LastFloatingReferenceBuilder extends LastFloatingReference, RosettaModelObjectBuilder {
		LastFloatingReference.LastFloatingReferenceBuilder setLastFloatingReferenceResetDateLeg1(Date lastFloatingReferenceResetDateLeg1);
		LastFloatingReference.LastFloatingReferenceBuilder setLastFloatingReferenceResetDateLeg2(Date lastFloatingReferenceResetDateLeg2);
		LastFloatingReference.LastFloatingReferenceBuilder setLastFloatingReferenceValueLeg1(BigDecimal lastFloatingReferenceValueLeg1);
		LastFloatingReference.LastFloatingReferenceBuilder setLastFloatingReferenceValueLeg2(BigDecimal lastFloatingReferenceValueLeg2);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("lastFloatingReferenceResetDateLeg1"), Date.class, getLastFloatingReferenceResetDateLeg1(), this);
			processor.processBasic(path.newSubPath("lastFloatingReferenceResetDateLeg2"), Date.class, getLastFloatingReferenceResetDateLeg2(), this);
			processor.processBasic(path.newSubPath("lastFloatingReferenceValueLeg1"), BigDecimal.class, getLastFloatingReferenceValueLeg1(), this);
			processor.processBasic(path.newSubPath("lastFloatingReferenceValueLeg2"), BigDecimal.class, getLastFloatingReferenceValueLeg2(), this);
		}
		

		LastFloatingReference.LastFloatingReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of LastFloatingReference  ***********************/
	class LastFloatingReferenceImpl implements LastFloatingReference {
		private final Date lastFloatingReferenceResetDateLeg1;
		private final Date lastFloatingReferenceResetDateLeg2;
		private final BigDecimal lastFloatingReferenceValueLeg1;
		private final BigDecimal lastFloatingReferenceValueLeg2;
		
		protected LastFloatingReferenceImpl(LastFloatingReference.LastFloatingReferenceBuilder builder) {
			this.lastFloatingReferenceResetDateLeg1 = builder.getLastFloatingReferenceResetDateLeg1();
			this.lastFloatingReferenceResetDateLeg2 = builder.getLastFloatingReferenceResetDateLeg2();
			this.lastFloatingReferenceValueLeg1 = builder.getLastFloatingReferenceValueLeg1();
			this.lastFloatingReferenceValueLeg2 = builder.getLastFloatingReferenceValueLeg2();
		}
		
		@Override
		@RosettaAttribute("lastFloatingReferenceResetDateLeg1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastFloatingReferenceResetDateLeg1")
		public Date getLastFloatingReferenceResetDateLeg1() {
			return lastFloatingReferenceResetDateLeg1;
		}
		
		@Override
		@RosettaAttribute("lastFloatingReferenceResetDateLeg2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastFloatingReferenceResetDateLeg2")
		public Date getLastFloatingReferenceResetDateLeg2() {
			return lastFloatingReferenceResetDateLeg2;
		}
		
		@Override
		@RosettaAttribute("lastFloatingReferenceValueLeg1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastFloatingReferenceValueLeg1")
		public BigDecimal getLastFloatingReferenceValueLeg1() {
			return lastFloatingReferenceValueLeg1;
		}
		
		@Override
		@RosettaAttribute("lastFloatingReferenceValueLeg2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastFloatingReferenceValueLeg2")
		public BigDecimal getLastFloatingReferenceValueLeg2() {
			return lastFloatingReferenceValueLeg2;
		}
		
		@Override
		public LastFloatingReference build() {
			return this;
		}
		
		@Override
		public LastFloatingReference.LastFloatingReferenceBuilder toBuilder() {
			LastFloatingReference.LastFloatingReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LastFloatingReference.LastFloatingReferenceBuilder builder) {
			ofNullable(getLastFloatingReferenceResetDateLeg1()).ifPresent(builder::setLastFloatingReferenceResetDateLeg1);
			ofNullable(getLastFloatingReferenceResetDateLeg2()).ifPresent(builder::setLastFloatingReferenceResetDateLeg2);
			ofNullable(getLastFloatingReferenceValueLeg1()).ifPresent(builder::setLastFloatingReferenceValueLeg1);
			ofNullable(getLastFloatingReferenceValueLeg2()).ifPresent(builder::setLastFloatingReferenceValueLeg2);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LastFloatingReference _that = getType().cast(o);
		
			if (!Objects.equals(lastFloatingReferenceResetDateLeg1, _that.getLastFloatingReferenceResetDateLeg1())) return false;
			if (!Objects.equals(lastFloatingReferenceResetDateLeg2, _that.getLastFloatingReferenceResetDateLeg2())) return false;
			if (!Objects.equals(lastFloatingReferenceValueLeg1, _that.getLastFloatingReferenceValueLeg1())) return false;
			if (!Objects.equals(lastFloatingReferenceValueLeg2, _that.getLastFloatingReferenceValueLeg2())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lastFloatingReferenceResetDateLeg1 != null ? lastFloatingReferenceResetDateLeg1.hashCode() : 0);
			_result = 31 * _result + (lastFloatingReferenceResetDateLeg2 != null ? lastFloatingReferenceResetDateLeg2.hashCode() : 0);
			_result = 31 * _result + (lastFloatingReferenceValueLeg1 != null ? lastFloatingReferenceValueLeg1.hashCode() : 0);
			_result = 31 * _result + (lastFloatingReferenceValueLeg2 != null ? lastFloatingReferenceValueLeg2.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LastFloatingReference {" +
				"lastFloatingReferenceResetDateLeg1=" + this.lastFloatingReferenceResetDateLeg1 + ", " +
				"lastFloatingReferenceResetDateLeg2=" + this.lastFloatingReferenceResetDateLeg2 + ", " +
				"lastFloatingReferenceValueLeg1=" + this.lastFloatingReferenceValueLeg1 + ", " +
				"lastFloatingReferenceValueLeg2=" + this.lastFloatingReferenceValueLeg2 +
			'}';
		}
	}

	/*********************** Builder Implementation of LastFloatingReference  ***********************/
	class LastFloatingReferenceBuilderImpl implements LastFloatingReference.LastFloatingReferenceBuilder {
	
		protected Date lastFloatingReferenceResetDateLeg1;
		protected Date lastFloatingReferenceResetDateLeg2;
		protected BigDecimal lastFloatingReferenceValueLeg1;
		protected BigDecimal lastFloatingReferenceValueLeg2;
		
		@Override
		@RosettaAttribute("lastFloatingReferenceResetDateLeg1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastFloatingReferenceResetDateLeg1")
		public Date getLastFloatingReferenceResetDateLeg1() {
			return lastFloatingReferenceResetDateLeg1;
		}
		
		@Override
		@RosettaAttribute("lastFloatingReferenceResetDateLeg2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastFloatingReferenceResetDateLeg2")
		public Date getLastFloatingReferenceResetDateLeg2() {
			return lastFloatingReferenceResetDateLeg2;
		}
		
		@Override
		@RosettaAttribute("lastFloatingReferenceValueLeg1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastFloatingReferenceValueLeg1")
		public BigDecimal getLastFloatingReferenceValueLeg1() {
			return lastFloatingReferenceValueLeg1;
		}
		
		@Override
		@RosettaAttribute("lastFloatingReferenceValueLeg2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastFloatingReferenceValueLeg2")
		public BigDecimal getLastFloatingReferenceValueLeg2() {
			return lastFloatingReferenceValueLeg2;
		}
		
		@RosettaAttribute("lastFloatingReferenceResetDateLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceResetDateLeg1")
		@Override
		public LastFloatingReference.LastFloatingReferenceBuilder setLastFloatingReferenceResetDateLeg1(Date _lastFloatingReferenceResetDateLeg1) {
			this.lastFloatingReferenceResetDateLeg1 = _lastFloatingReferenceResetDateLeg1 == null ? null : _lastFloatingReferenceResetDateLeg1;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceResetDateLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceResetDateLeg2")
		@Override
		public LastFloatingReference.LastFloatingReferenceBuilder setLastFloatingReferenceResetDateLeg2(Date _lastFloatingReferenceResetDateLeg2) {
			this.lastFloatingReferenceResetDateLeg2 = _lastFloatingReferenceResetDateLeg2 == null ? null : _lastFloatingReferenceResetDateLeg2;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceValueLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceValueLeg1")
		@Override
		public LastFloatingReference.LastFloatingReferenceBuilder setLastFloatingReferenceValueLeg1(BigDecimal _lastFloatingReferenceValueLeg1) {
			this.lastFloatingReferenceValueLeg1 = _lastFloatingReferenceValueLeg1 == null ? null : _lastFloatingReferenceValueLeg1;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceValueLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceValueLeg2")
		@Override
		public LastFloatingReference.LastFloatingReferenceBuilder setLastFloatingReferenceValueLeg2(BigDecimal _lastFloatingReferenceValueLeg2) {
			this.lastFloatingReferenceValueLeg2 = _lastFloatingReferenceValueLeg2 == null ? null : _lastFloatingReferenceValueLeg2;
			return this;
		}
		
		@Override
		public LastFloatingReference build() {
			return new LastFloatingReference.LastFloatingReferenceImpl(this);
		}
		
		@Override
		public LastFloatingReference.LastFloatingReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LastFloatingReference.LastFloatingReferenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLastFloatingReferenceResetDateLeg1()!=null) return true;
			if (getLastFloatingReferenceResetDateLeg2()!=null) return true;
			if (getLastFloatingReferenceValueLeg1()!=null) return true;
			if (getLastFloatingReferenceValueLeg2()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LastFloatingReference.LastFloatingReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LastFloatingReference.LastFloatingReferenceBuilder o = (LastFloatingReference.LastFloatingReferenceBuilder) other;
			
			
			merger.mergeBasic(getLastFloatingReferenceResetDateLeg1(), o.getLastFloatingReferenceResetDateLeg1(), this::setLastFloatingReferenceResetDateLeg1);
			merger.mergeBasic(getLastFloatingReferenceResetDateLeg2(), o.getLastFloatingReferenceResetDateLeg2(), this::setLastFloatingReferenceResetDateLeg2);
			merger.mergeBasic(getLastFloatingReferenceValueLeg1(), o.getLastFloatingReferenceValueLeg1(), this::setLastFloatingReferenceValueLeg1);
			merger.mergeBasic(getLastFloatingReferenceValueLeg2(), o.getLastFloatingReferenceValueLeg2(), this::setLastFloatingReferenceValueLeg2);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LastFloatingReference _that = getType().cast(o);
		
			if (!Objects.equals(lastFloatingReferenceResetDateLeg1, _that.getLastFloatingReferenceResetDateLeg1())) return false;
			if (!Objects.equals(lastFloatingReferenceResetDateLeg2, _that.getLastFloatingReferenceResetDateLeg2())) return false;
			if (!Objects.equals(lastFloatingReferenceValueLeg1, _that.getLastFloatingReferenceValueLeg1())) return false;
			if (!Objects.equals(lastFloatingReferenceValueLeg2, _that.getLastFloatingReferenceValueLeg2())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lastFloatingReferenceResetDateLeg1 != null ? lastFloatingReferenceResetDateLeg1.hashCode() : 0);
			_result = 31 * _result + (lastFloatingReferenceResetDateLeg2 != null ? lastFloatingReferenceResetDateLeg2.hashCode() : 0);
			_result = 31 * _result + (lastFloatingReferenceValueLeg1 != null ? lastFloatingReferenceValueLeg1.hashCode() : 0);
			_result = 31 * _result + (lastFloatingReferenceValueLeg2 != null ? lastFloatingReferenceValueLeg2.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LastFloatingReferenceBuilder {" +
				"lastFloatingReferenceResetDateLeg1=" + this.lastFloatingReferenceResetDateLeg1 + ", " +
				"lastFloatingReferenceResetDateLeg2=" + this.lastFloatingReferenceResetDateLeg2 + ", " +
				"lastFloatingReferenceValueLeg1=" + this.lastFloatingReferenceValueLeg1 + ", " +
				"lastFloatingReferenceValueLeg2=" + this.lastFloatingReferenceValueLeg2 +
			'}';
		}
	}
}

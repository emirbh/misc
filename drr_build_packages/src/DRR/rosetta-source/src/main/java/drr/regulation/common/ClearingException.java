package drr.regulation.common;

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
import drr.regulation.common.meta.ClearingExceptionMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies information related to clearing exceptions or exemptions that are applied to the trade.
 * @version 7.7.0
 */
@RosettaDataType(value="ClearingException", builder=ClearingException.ClearingExceptionBuilderImpl.class, version="7.7.0")
@RuneDataType(value="ClearingException", model="drr", builder=ClearingException.ClearingExceptionBuilderImpl.class, version="7.7.0")
public interface ClearingException extends RosettaModelObject {

	ClearingExceptionMeta metaData = new ClearingExceptionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indication of whether an exception from normal clearing mandates is being applied caused by the type of the parties or their relationship, such as inter-affiliate trades.
	 */
	Boolean getClearingException();
	/**
	 * Identifies the type of clearing exception or exemption that the counterparty has elected.
	 */
	List<ClearingExceptionReasonEnum> getClearingExceptionReason();
	/**
	 * Specifies supporting evidence when claiming an end user exception.
	 */
	ClearingExceptionDeclaration getClearingExceptionDeclaration();

	/*********************** Build Methods  ***********************/
	ClearingException build();
	
	ClearingException.ClearingExceptionBuilder toBuilder();
	
	static ClearingException.ClearingExceptionBuilder builder() {
		return new ClearingException.ClearingExceptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingException> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ClearingException> getType() {
		return ClearingException.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("clearingException"), Boolean.class, getClearingException(), this);
		processor.processBasic(path.newSubPath("clearingExceptionReason"), ClearingExceptionReasonEnum.class, getClearingExceptionReason(), this);
		processRosetta(path.newSubPath("clearingExceptionDeclaration"), processor, ClearingExceptionDeclaration.class, getClearingExceptionDeclaration());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingExceptionBuilder extends ClearingException, RosettaModelObjectBuilder {
		ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder getOrCreateClearingExceptionDeclaration();
		@Override
		ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder getClearingExceptionDeclaration();
		ClearingException.ClearingExceptionBuilder setClearingException(Boolean clearingException);
		ClearingException.ClearingExceptionBuilder addClearingExceptionReason(ClearingExceptionReasonEnum clearingExceptionReason);
		ClearingException.ClearingExceptionBuilder addClearingExceptionReason(ClearingExceptionReasonEnum clearingExceptionReason, int idx);
		ClearingException.ClearingExceptionBuilder addClearingExceptionReason(List<ClearingExceptionReasonEnum> clearingExceptionReason);
		ClearingException.ClearingExceptionBuilder setClearingExceptionReason(List<ClearingExceptionReasonEnum> clearingExceptionReason);
		ClearingException.ClearingExceptionBuilder setClearingExceptionDeclaration(ClearingExceptionDeclaration clearingExceptionDeclaration);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("clearingException"), Boolean.class, getClearingException(), this);
			processor.processBasic(path.newSubPath("clearingExceptionReason"), ClearingExceptionReasonEnum.class, getClearingExceptionReason(), this);
			processRosetta(path.newSubPath("clearingExceptionDeclaration"), processor, ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder.class, getClearingExceptionDeclaration());
		}
		

		ClearingException.ClearingExceptionBuilder prune();
	}

	/*********************** Immutable Implementation of ClearingException  ***********************/
	class ClearingExceptionImpl implements ClearingException {
		private final Boolean clearingException;
		private final List<ClearingExceptionReasonEnum> clearingExceptionReason;
		private final ClearingExceptionDeclaration clearingExceptionDeclaration;
		
		protected ClearingExceptionImpl(ClearingException.ClearingExceptionBuilder builder) {
			this.clearingException = builder.getClearingException();
			this.clearingExceptionReason = ofNullable(builder.getClearingExceptionReason()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.clearingExceptionDeclaration = ofNullable(builder.getClearingExceptionDeclaration()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("clearingException")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingException")
		public Boolean getClearingException() {
			return clearingException;
		}
		
		@Override
		@RosettaAttribute("clearingExceptionReason")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("clearingExceptionReason")
		public List<ClearingExceptionReasonEnum> getClearingExceptionReason() {
			return clearingExceptionReason;
		}
		
		@Override
		@RosettaAttribute("clearingExceptionDeclaration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingExceptionDeclaration")
		public ClearingExceptionDeclaration getClearingExceptionDeclaration() {
			return clearingExceptionDeclaration;
		}
		
		@Override
		public ClearingException build() {
			return this;
		}
		
		@Override
		public ClearingException.ClearingExceptionBuilder toBuilder() {
			ClearingException.ClearingExceptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingException.ClearingExceptionBuilder builder) {
			ofNullable(getClearingException()).ifPresent(builder::setClearingException);
			ofNullable(getClearingExceptionReason()).ifPresent(builder::setClearingExceptionReason);
			ofNullable(getClearingExceptionDeclaration()).ifPresent(builder::setClearingExceptionDeclaration);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingException _that = getType().cast(o);
		
			if (!Objects.equals(clearingException, _that.getClearingException())) return false;
			if (!ListEquals.listEquals(clearingExceptionReason, _that.getClearingExceptionReason())) return false;
			if (!Objects.equals(clearingExceptionDeclaration, _that.getClearingExceptionDeclaration())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (clearingException != null ? clearingException.hashCode() : 0);
			_result = 31 * _result + (clearingExceptionReason != null ? clearingExceptionReason.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (clearingExceptionDeclaration != null ? clearingExceptionDeclaration.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingException {" +
				"clearingException=" + this.clearingException + ", " +
				"clearingExceptionReason=" + this.clearingExceptionReason + ", " +
				"clearingExceptionDeclaration=" + this.clearingExceptionDeclaration +
			'}';
		}
	}

	/*********************** Builder Implementation of ClearingException  ***********************/
	class ClearingExceptionBuilderImpl implements ClearingException.ClearingExceptionBuilder {
	
		protected Boolean clearingException;
		protected List<ClearingExceptionReasonEnum> clearingExceptionReason = new ArrayList<>();
		protected ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder clearingExceptionDeclaration;
		
		@Override
		@RosettaAttribute("clearingException")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingException")
		public Boolean getClearingException() {
			return clearingException;
		}
		
		@Override
		@RosettaAttribute("clearingExceptionReason")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("clearingExceptionReason")
		public List<ClearingExceptionReasonEnum> getClearingExceptionReason() {
			return clearingExceptionReason;
		}
		
		@Override
		@RosettaAttribute("clearingExceptionDeclaration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingExceptionDeclaration")
		public ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder getClearingExceptionDeclaration() {
			return clearingExceptionDeclaration;
		}
		
		@Override
		public ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder getOrCreateClearingExceptionDeclaration() {
			ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder result;
			if (clearingExceptionDeclaration!=null) {
				result = clearingExceptionDeclaration;
			}
			else {
				result = clearingExceptionDeclaration = ClearingExceptionDeclaration.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("clearingException")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingException")
		@Override
		public ClearingException.ClearingExceptionBuilder setClearingException(Boolean _clearingException) {
			this.clearingException = _clearingException == null ? null : _clearingException;
			return this;
		}
		
		@RosettaAttribute("clearingExceptionReason")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("clearingExceptionReason")
		@Override
		public ClearingException.ClearingExceptionBuilder addClearingExceptionReason(ClearingExceptionReasonEnum _clearingExceptionReason) {
			if (_clearingExceptionReason != null) {
				this.clearingExceptionReason.add(_clearingExceptionReason);
			}
			return this;
		}
		
		@Override
		public ClearingException.ClearingExceptionBuilder addClearingExceptionReason(ClearingExceptionReasonEnum _clearingExceptionReason, int idx) {
			getIndex(this.clearingExceptionReason, idx, () -> _clearingExceptionReason);
			return this;
		}
		
		@Override
		public ClearingException.ClearingExceptionBuilder addClearingExceptionReason(List<ClearingExceptionReasonEnum> clearingExceptionReasons) {
			if (clearingExceptionReasons != null) {
				for (final ClearingExceptionReasonEnum toAdd : clearingExceptionReasons) {
					this.clearingExceptionReason.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("clearingExceptionReason")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("clearingExceptionReason")
		@Override
		public ClearingException.ClearingExceptionBuilder setClearingExceptionReason(List<ClearingExceptionReasonEnum> clearingExceptionReasons) {
			if (clearingExceptionReasons == null) {
				this.clearingExceptionReason = new ArrayList<>();
			} else {
				this.clearingExceptionReason = clearingExceptionReasons.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("clearingExceptionDeclaration")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingExceptionDeclaration")
		@Override
		public ClearingException.ClearingExceptionBuilder setClearingExceptionDeclaration(ClearingExceptionDeclaration _clearingExceptionDeclaration) {
			this.clearingExceptionDeclaration = _clearingExceptionDeclaration == null ? null : _clearingExceptionDeclaration.toBuilder();
			return this;
		}
		
		@Override
		public ClearingException build() {
			return new ClearingException.ClearingExceptionImpl(this);
		}
		
		@Override
		public ClearingException.ClearingExceptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingException.ClearingExceptionBuilder prune() {
			if (clearingExceptionDeclaration!=null && !clearingExceptionDeclaration.prune().hasData()) clearingExceptionDeclaration = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getClearingException()!=null) return true;
			if (getClearingExceptionReason()!=null && !getClearingExceptionReason().isEmpty()) return true;
			if (getClearingExceptionDeclaration()!=null && getClearingExceptionDeclaration().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingException.ClearingExceptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ClearingException.ClearingExceptionBuilder o = (ClearingException.ClearingExceptionBuilder) other;
			
			merger.mergeRosetta(getClearingExceptionDeclaration(), o.getClearingExceptionDeclaration(), this::setClearingExceptionDeclaration);
			
			merger.mergeBasic(getClearingException(), o.getClearingException(), this::setClearingException);
			merger.mergeBasic(getClearingExceptionReason(), o.getClearingExceptionReason(), (Consumer<ClearingExceptionReasonEnum>) this::addClearingExceptionReason);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingException _that = getType().cast(o);
		
			if (!Objects.equals(clearingException, _that.getClearingException())) return false;
			if (!ListEquals.listEquals(clearingExceptionReason, _that.getClearingExceptionReason())) return false;
			if (!Objects.equals(clearingExceptionDeclaration, _that.getClearingExceptionDeclaration())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (clearingException != null ? clearingException.hashCode() : 0);
			_result = 31 * _result + (clearingExceptionReason != null ? clearingExceptionReason.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (clearingExceptionDeclaration != null ? clearingExceptionDeclaration.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingExceptionBuilder {" +
				"clearingException=" + this.clearingException + ", " +
				"clearingExceptionReason=" + this.clearingExceptionReason + ", " +
				"clearingExceptionDeclaration=" + this.clearingExceptionDeclaration +
			'}';
		}
	}
}
